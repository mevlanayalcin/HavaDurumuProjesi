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

public class KendiWebServisimizIcinClient
{
    public static HavaDurumu bizimWebServistenVeriCek(String sehirAdi) throws ParseException {
        Client client= ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/servis/weather/city?sehir="+sehirAdi);


        JSONParser jsonParser = new JSONParser();
        JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class) );

        String sehir=(String)anaObject.get("sehir");
        String durum=(String)anaObject.get("durum");
        long sicaklik=(long)anaObject.get("sicaklik");
        long basinc=(long)anaObject.get("basinc");
        long nem=(long)anaObject.get("nem_orani");

        HavaDurumu havaDurumu=new HavaDurumu(sehir,durum,sicaklik,basinc,nem);

        return havaDurumu;
    }
}
