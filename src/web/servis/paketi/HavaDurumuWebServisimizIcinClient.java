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
import java.util.ArrayList;
import java.util.List;

public class HavaDurumuWebServisimizIcinClient
{
    public static List<HavaDurumu> bizimWebServistenVeriCek(String sehirAdi) throws ParseException {
        Client client= ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/service/weather/city?sehir="+sehirAdi);

        List<HavaDurumu> havaDurumuList=new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONArray anaObject = (JSONArray) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class) );

        for (int i=0;i<13;i++)
        {
            JSONObject gunObjesi = (JSONObject) anaObject.get(i);
            String sehir = (String) gunObjesi.get("sehir");
            String durum = (String) gunObjesi.get("durum");
            long sicaklik = (long) gunObjesi.get("sicaklik");
            long basinc = (long) gunObjesi.get("basinc");
            long nem = (long) gunObjesi.get("nem_orani");
            String zaman = (String) gunObjesi.get("zaman");

            HavaDurumu havaDurumu = new HavaDurumu(sehir, durum, sicaklik, basinc, nem, zaman);
            havaDurumuList.add(havaDurumu);

        }
        return havaDurumuList;

    }


    public static void main(String[] args) throws ParseException {

        List<HavaDurumu>havaDurumuList=new ArrayList<>();
        havaDurumuList= HavaDurumuWebServisimizIcinClient.bizimWebServistenVeriCek("ANKARA");
        for(HavaDurumu havaDurumu:havaDurumuList)
        {
            System.out.println(havaDurumu);
        }
    }
}
