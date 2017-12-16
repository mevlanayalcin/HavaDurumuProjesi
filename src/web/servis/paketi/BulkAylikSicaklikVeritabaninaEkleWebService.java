package web.servis.paketi;

import hibernate.paketi.AylikYillikSicaklik;
import hibernate.paketi.AylikYillikSicaklikKaydet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class BulkAylikSicaklikVeritabaninaEkleWebService
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
        for(int a=0;a<sehirlerDizisi.length;a++)
        {
            WebTarget target = client.target("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=64a123cdad96489f9df213312171312&q=" + sehirlerDizisi[a] + "&format=json");

            JSONParser jsonParser = new JSONParser();
            JSONObject anaObject = (JSONObject) jsonParser.parse(target.request(MediaType.APPLICATION_JSON).get(String.class));
            JSONObject dataObject = (JSONObject) anaObject.get("data");
            //Burada sehire göre aylık ve yillik ortalama sıcaklık değerlerini tanımladık.

            String sehrimiz = null;
            long ocak=0;
            long subat=0;
            long mart=0;
            long nisan=0;
            long mayis=0;
            long haziran=0;
            long temmuz=0;
            long agustos=0;
            long eylul=0;
            long ekim=0;
            long kasim=0;
            long aralik=0;
            long yillikOrtalama=0;


        /*  Tam burada yani aşağıda şehrin  aylık ve yıllık hava durumu sıcaklık ortalamasını alıyoruz,ay ay min ve max sıcaklık ortalamalarını alıp
                 toplayıp 2 ye bölüp aylık ortalama sıcaklık değerini alıyoruz.En son aylıkları toplayıp 12 ye bölüp yıllık ortalama alıyoruz.
             */

            JSONArray ClimateAveragesDizisi = (JSONArray) dataObject.get("ClimateAverages");
            JSONObject ClimateAveragesDizisiIlkTerimi = (JSONObject) ClimateAveragesDizisi.get(0);
            JSONArray monthDizisi = (JSONArray) ClimateAveragesDizisiIlkTerimi.get("month");

            sehrimiz = sehirlerDizisi[a];

            long yillikToplamSicaklik = 0;
            for (int t = 0; t < 12; t++)//12 ay olduğu için 12 defa dönecek ve aylara göre average sıcaklıkları bastıracak en son yıllık averageyi basacak
            {
                JSONObject monthDizisiObjesi = (JSONObject) monthDizisi.get(t);
                String avrMin = (String) monthDizisiObjesi.get("avgMinTemp");
                String avrMax = (String) monthDizisiObjesi.get("absMaxTemp");
                double avarageMin = Double.parseDouble(avrMin);
                double avarageMax = Double.parseDouble(avrMax);
                double avarageSicaklikAylik = (avarageMin + avarageMax) / 2;
                long longAvarage=Math.round(avarageSicaklikAylik);
                yillikToplamSicaklik=yillikToplamSicaklik+longAvarage;

                //t nin değerlerine göre aylara sıcaklık ortalaması atanıyor t=0 ise Ocak ayına atanacak
                if(t==0)
                {
                    ocak=longAvarage;
                }
                if(t==1)
                {
                    subat=longAvarage;
                }
                if(t==2)
                {
                    mart=longAvarage;
                }
                if(t==3)
                {
                    nisan=longAvarage;
                }
                if(t==4)
                {
                    mayis=longAvarage;
                }
                if(t==5)
                {
                    haziran=longAvarage;
                }
                if(t==6)
                {
                    temmuz=longAvarage;
                }
                if(t==7)
                {
                    agustos=longAvarage;
                }
                if(t==8)
                {
                    eylul=longAvarage;
                }
                if(t==9)
                {
                    ekim=longAvarage;
                }
                if(t==10)
                {
                    kasim=longAvarage;
                }
                if(t==11)
                {
                    aralik=longAvarage;
                }


            }
            yillikOrtalama=yillikToplamSicaklik/12;//Yillik toplam sicaklık ortalamasını 12 ye bölüp yıllık sıcaklık ortalamasını buluyoruz


            //Web servisten çektiğimiz bulk aylık sıcaklık değerlerini AylikYillikSicaklik sınıfımızın değerlerine atıyoruz
            AylikYillikSicaklik aylikYillikSicaklikObjemiz=new AylikYillikSicaklik(sehrimiz,ocak,subat,mart,nisan,mayis,haziran,temmuz,agustos,eylul
            ,ekim,kasim,aralik,yillikOrtalama);

            System.out.println(aylikYillikSicaklikObjemiz.getSehir()+"Sehrinin : "+" Ocak ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getOcak()
                    +" Subat ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getSubat()
                    +" Mart ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getMart()
                    +" Nisan ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getNisan()
                    +" Mayis ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getMayis()
                    +" Haziran ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getHaziran()
                    +" Temmuz ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getTemmuz()
                    +" Agustos ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getAgustos()
                    +" Eylul ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getEylul()
                    +" Ekim ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getEkim()
                    +" Kasım ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getKasim()
                    +" Aralık ayi sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getAralik()
                    +" 2017 yılı sicaklik ortalamasi :"+aylikYillikSicaklikObjemiz.getYillik() );

            AylikYillikSicaklikKaydet.databaseVeriEkle(aylikYillikSicaklikObjemiz);

        }

    }

    public static void main(String[] args) throws ParseException {
        bulkDatayiVeritabaninaEkle();
    }
}
