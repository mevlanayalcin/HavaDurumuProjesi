package web.servis.paketi;

import hibernate.paketi.AylikYillikSicaklik;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AylikSicaklikWebServisimizIcinClient
{
    public static AylikYillikSicaklik bizimWebServistenVeriCek(String sehirAdi) throws ParseException
    {
        Client client= ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/service/weather/temperature?sehir="+sehirAdi);

        JSONParser jsonParser = new JSONParser();
        JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class) );



        String sehir=(String)anaObject.get("sehir");
        long ocak=(long)anaObject.get("ocak");
        long subat=(long)anaObject.get("subat");
        long mart=(long)anaObject.get("mart");
        long nisan=(long)anaObject.get("nisan");
        long mayis=(long)anaObject.get("mayis");
        long haziran=(long)anaObject.get("haziran");
        long temmuz=(long)anaObject.get("temmuz");
        long agustos=(long)anaObject.get("agustos");
        long eylul=(long)anaObject.get("eylul");
        long ekim=(long)anaObject.get("ekim");
        long kasim=(long)anaObject.get("kasim");
        long aralik=(long)anaObject.get("aralik");
        long yillik=(long)anaObject.get("yillik");

        AylikYillikSicaklik aylikYillikSicaklik=new AylikYillikSicaklik(sehir,ocak,subat,mart,nisan,mayis,haziran,temmuz,agustos,eylul,ekim,kasim,aralik,yillik);

        return aylikYillikSicaklik;




    }

}
