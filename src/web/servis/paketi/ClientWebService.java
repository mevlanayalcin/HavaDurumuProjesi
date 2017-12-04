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
        WebTarget target=client.target("http://api.openweathermap.org/data/2.5/weather?q="+sehirAdi+"&units=metric&APPID=1e1d2819dea94babccbc342ad75b5b97");


        JSONParser jsonParser = new JSONParser();
        JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class) );
        JSONObject mainObject=(JSONObject) anaObject.get("main");

        JSONArray weatherDizi=(JSONArray)anaObject.get("weather");
        JSONObject weather0Objesi=(JSONObject) weatherDizi.get(0);

        long sicaklik=0;
        double sicak=0.0;
        if(mainObject.get("temp") instanceof Double)
        {
            sicak=(Double)mainObject.get("temp");
            sicaklik=(long)sicak;
        }
        if(mainObject.get("temp") instanceof Long)
        {
            sicaklik = (long) mainObject.get("temp");
        }

        long basinc=0;
        double basin=0.0;
        if(mainObject.get("pressure") instanceof Double)
        {
            basin=(Double)mainObject.get("pressure");
            basinc=(long)basin;
        }
        if(mainObject.get("pressure") instanceof Long)
        {
            basinc = (long) mainObject.get("pressure");
        }


        long nem=(long)mainObject.get("humidity");
        String sehir=(String)anaObject.get("name");
        String havaDurumu=(String)weather0Objesi.get("description");


        HavaDurumu havaDurumuObjesi=new HavaDurumu(sehir,havaDurumu,sicaklik,basinc,nem);
        System.out.println(havaDurumuObjesi);


        return havaDurumuObjesi;
    }
}
