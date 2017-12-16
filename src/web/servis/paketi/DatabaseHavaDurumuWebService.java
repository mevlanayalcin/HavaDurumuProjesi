package web.servis.paketi;

import hibernate.paketi.HavaDurumuVerisiGetir;
import hibernate.paketi.HavaDurumu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weather")
public class DatabaseHavaDurumuWebService
{
    @GET
    @Path("/city")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<HavaDurumu> sehreGoreHavaDurumuGetir(@QueryParam("sehir") String sehir)
    {

        List<HavaDurumu> obje = HavaDurumuVerisiGetir.databaseVeriGetir(sehir);
        return obje;

    }
}