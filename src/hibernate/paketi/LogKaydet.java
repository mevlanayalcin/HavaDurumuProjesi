package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LogKaydet
{
    public  static void databaseVeriEkle(Log log)
    {
        SessionFactory sessionFactory= LogSessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try
        {

            session.beginTransaction();
            session.save(log);
            session.getTransaction().commit();
        }
        finally
        {
            session.close();
        }
    }
}
