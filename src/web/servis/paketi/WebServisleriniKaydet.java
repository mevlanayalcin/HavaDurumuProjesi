package web.servis.paketi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("/service")

//@ApplicationPath("/") OK
//@ApplicationPath("/*") Don't use /*
//@ApplicationPath("/root-path/*") Don't use /*

public class WebServisleriniKaydet extends Application{

    private Set<Object> singletons = new HashSet<Object>();

    public WebServisleriniKaydet() {
        singletons.add(new DatabaseHavaDurumuWebService());
        singletons.add(new DatabaseAylikSicaklikWebService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
