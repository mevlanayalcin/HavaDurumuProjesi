package web.servis.paketi;

import hibernate.paketi.HavaDurumu;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientWebService
{
    public static HavaDurumu webServistenVeriCek(String sehirAdi) throws ParseException {
        Client client= ClientBuilder.newClient();
        WebTarget target=client.target("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=64a123cdad96489f9df213312171312&q=" + sehirAdi + "&format=json");

        JSONParser jsonParser = new JSONParser();
        JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class) );
        JSONObject dataObject=(JSONObject) anaObject.get("data");

        JSONArray current_conditionDizisi=(JSONArray)dataObject.get("current_condition");
        JSONObject current_conditionDizisiSifirinciTerimObjesi=(JSONObject)current_conditionDizisi.get(0);


        String cekilenSaat=(String)current_conditionDizisiSifirinciTerimObjesi.get("observation_time");

        long sicaklik=0;
        double sicak=0.0;
        if(current_conditionDizisiSifirinciTerimObjesi.get("temp_C") instanceof Double)
        {
            sicak=(Double)current_conditionDizisiSifirinciTerimObjesi.get("temp_C");
            sicaklik=(long)sicak;
        }
        if(current_conditionDizisiSifirinciTerimObjesi.get("temp_C") instanceof Long)
        {
            sicaklik = (long) current_conditionDizisiSifirinciTerimObjesi.get("temp_C");
        }
        else
        {
            String sicakkk=(String)current_conditionDizisiSifirinciTerimObjesi.get("temp_C");
            sicaklik=Long.parseLong(sicakkk);
        }


        long basinc=0;
        double basin=0.0;
        if(current_conditionDizisiSifirinciTerimObjesi.get("pressure") instanceof Double)
        {
            basin=(Double)current_conditionDizisiSifirinciTerimObjesi.get("pressure");
            basinc=(long)basin;
        }
        if(current_conditionDizisiSifirinciTerimObjesi.get("pressure") instanceof Long)
        {
            basinc = (long) current_conditionDizisiSifirinciTerimObjesi.get("pressure");
        }
        else
        {
            String press=(String)current_conditionDizisiSifirinciTerimObjesi.get("pressure");
            basinc=Long.parseLong(press);
        }

        String nem1=(String)current_conditionDizisiSifirinciTerimObjesi.get("humidity");
        long nem=Long.parseLong(nem1);


        String sehir=sehirAdi;

        //Gökyüzünün durumunu alıyoruz
        JSONArray weatherDescArray=(JSONArray)current_conditionDizisiSifirinciTerimObjesi.get("weatherDesc");
        JSONObject weatherDescObject=(JSONObject) weatherDescArray.get(0);

        String havaDurumu=(String)weatherDescObject.get("value");


        HavaDurumu havaDurumuObjesi=new HavaDurumu(sehir,havaDurumu,sicaklik,basinc,nem,cekilenSaat);
        System.out.println(havaDurumuObjesi);



        return havaDurumuObjesi;
    }
}
