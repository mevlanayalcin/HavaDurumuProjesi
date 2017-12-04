package web.servis.paketi;

import hibernate.paketi.DatabaseVeriCek;
import hibernate.paketi.HavaDurumu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class ServerWebService
{
    @GET
    @Path("/city")
    @Produces(MediaType.APPLICATION_JSON)
    public HavaDurumu sehreGoreHavaDurumuGetir(@QueryParam("sehir") String sehir)
    {

        HavaDurumu obje = DatabaseVeriCek.databaseVeriGetir(sehir);
        return obje;

    }
}