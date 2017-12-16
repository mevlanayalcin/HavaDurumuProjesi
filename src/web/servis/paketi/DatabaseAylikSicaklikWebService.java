package web.servis.paketi;

import hibernate.paketi.AylikYillikSicaklik;
import hibernate.paketi.AylikYillikSicaklikVerisiGetir;
import hibernate.paketi.HavaDurumu;
import hibernate.paketi.HavaDurumuVerisiGetir;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weather")
public class DatabaseAylikSicaklikWebService
{
    @GET
    @Path("/temperature")
    @Produces(MediaType.APPLICATION_JSON)
    public AylikYillikSicaklik sehreGoreAylikSicaklikGetir(@QueryParam("sehir") String sehir)
    {

        AylikYillikSicaklik obje = AylikYillikSicaklikVerisiGetir.databaseVeriGetir(sehir);
        return obje;

    }
}
