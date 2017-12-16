package hibernate.paketi;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AylikSicaklikSessionFactorySingleton
{
    private static SessionFactory factory;


    private AylikSicaklikSessionFactorySingleton()
    {
    }


    public static synchronized SessionFactory getSessionFactory()
    {

        if (factory == null)
        {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(AylikYillikSicaklik.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}

