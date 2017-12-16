package hibernate.paketi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LogSessionFactorySingleton
{
    private static SessionFactory factory;


    private LogSessionFactorySingleton()
    {
    }


    public static synchronized SessionFactory getSessionFactory()
    {

        if (factory == null)
        {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Log.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}
