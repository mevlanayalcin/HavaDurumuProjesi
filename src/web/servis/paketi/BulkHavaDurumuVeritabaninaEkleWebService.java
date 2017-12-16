package web.servis.paketi;

import hibernate.paketi.HavaDurumu;
import hibernate.paketi.HavaDurumuKaydet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class BulkHavaDurumuVeritabaninaEkleWebService
{
    public static void bulkDatayiVeritabaninaEkle() throws ParseException
    {

        String sehirlerDizisi[]={"ADANA","AFYONKARAHISAR","AGRI","AMASYA","ANKARA",
                "ANTALYA","ARTVIN","AYDIN","BILECIK","BINGOL","BITLIS","BOLU",
                "BURDUR","BURSA","CORUM","DENIZLI","DIYARBAKIR","EDIRNE","ERZINCAN",
                "ERZURUM","ESKISEHIR","GAZIANTEP","GIRESUN","HAKKARI","HATAY","ISPARTA","ISTANBUL",
                "IZMIR","KARS","KASTAMONU","KAYSERI","KIRSEHIR","KOCAELI","KONYA",
                "KUTAHYA","MANISA","MARDIN","MUGLA","MUS","NEVSEHIR",
                "NIGDE","ORDU","RIZE","SAKARYA","SAMSUN","SIIRT","SINOP","SIVAS","TEKIRDAG",
                "TOKAT","TRABZON","TUNCELI","SANLIURFA","USAK","VAN","YOZGAT","ZONGULDAK",
                "AKSARAY","BAYBURT","KIRIKKALE","BATMAN","SIRNAK","BARTIN",
                "ARDAHAN","IGDIR","YALOVA","KARABUK","KILIS","OSMANIYE","DUZCE"};

        Client client= ClientBuilder.newClient();
        for(int a=0;a<sehirlerDizisi.length;a++) {
            WebTarget target = client.target("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=64a123cdad96489f9df213312171312&q=" + sehirlerDizisi[a] + "&format=json");

            JSONParser jsonParser = new JSONParser();
            JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class));
            JSONObject dataObject = (JSONObject) anaObject.get("data");
            JSONArray weatherDizisi = (JSONArray) dataObject.get("weather");

            //Burada bizim için gerekli olan obje variablelerini tanımlıyoruz,null değerler atıyoruz ilk olarak

            String sehrimiz = null;
            String durum = null;
            String zaman = null;
            long sicaklik = 0;
            long basinc = 0;
            long nemlilik = 0;


            for (int i = 0; i < 14; i++)
            {//14 günlük veri için dönüyor
                JSONObject weatherDizisiObjesi = (JSONObject) weatherDizisi.get(i);//i.günün verisini obje olarak alıyoruz
                String sehirr = sehirlerDizisi[a];
                String date = (String) weatherDizisiObjesi.get("date");

                JSONArray birGununSaatlikVerisiDizi = (JSONArray) weatherDizisiObjesi.get("hourly");//i.günün saatlik veri dizisi
                JSONObject saatlikVeri = (JSONObject) birGununSaatlikVerisiDizi.get(0);
                // saatlik verinin 3. elemanını ortalama değer olsun diye JsonObjesi olarak aldık çünkü bir günü
                // 7 saate ayırmış.Burdan pressure basinc felan çekeceğiz.

                String sicaklikk = (String) saatlikVeri.get("tempC");
                String nemlilikk = (String) saatlikVeri.get("humidity");
                String basincc = (String) saatlikVeri.get("pressure");

                JSONArray havaninDurumuDizisi = (JSONArray) saatlikVeri.get("weatherDesc");
                JSONObject havaninDurumuObjesi = (JSONObject) havaninDurumuDizisi.get(0);
                String havaDurumu = (String) havaninDurumuObjesi.get("value");//weatherDesc dizisinin ilk indeksini objeye gökyüzü durumunu alıyoruz

            /*Gerekli dönüşümleri yapıp orjinal obje alanlarına atama yapıyoruz.Çünkü bazı json değerlerimiz String
               ancak veritabanında onları long olarak tutuyoruz bu yüzden String değerleri long'a parse edeceğiz.
             */
                sehrimiz = sehirr;
                durum = havaDurumu;
                zaman = date;
                sicaklik = Long.parseLong(sicaklikk);
                basinc = Long.parseLong(basincc);
                nemlilik = Long.parseLong(nemlilikk);

                HavaDurumu havaDurumuObjemiz=new HavaDurumu(sehrimiz,durum,sicaklik,basinc,nemlilik,zaman);
                HavaDurumuKaydet.databaseVeriEkle(havaDurumuObjemiz);
                System.out.println("Sehir :" + sehrimiz + " Tarih :" + zaman + " Sicaklik :" + sicaklik + " Nemlilik :" + nemlilik + " Basinc :" + basinc + " HavaDurumu :" + durum);
            }




        }

    }

    public static void main(String[] args) throws ParseException {
        bulkDatayiVeritabaninaEkle();
    }


}
