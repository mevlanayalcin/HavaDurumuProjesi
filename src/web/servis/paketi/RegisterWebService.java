package web.servis.paketi;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("/servis")

//@ApplicationPath("/") OK
//@ApplicationPath("/*") Don't use /*
//@ApplicationPath("/root-path/*") Don't use /*

public class RegisterWebService extends Application{

    private Set<Object> singletons = new HashSet<Object>();

    public RegisterWebService() {
        singletons.add(new ServerWebService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
