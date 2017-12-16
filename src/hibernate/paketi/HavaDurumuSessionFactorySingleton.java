package hibernate.paketi;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HavaDurumuSessionFactorySingleton
{
    private static SessionFactory factory;


    private HavaDurumuSessionFactorySingleton()
    {
    }


    public static synchronized SessionFactory getSessionFactory()
    {

        if (factory == null)
        {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(HavaDurumu.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}

