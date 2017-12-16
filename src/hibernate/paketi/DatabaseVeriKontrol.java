package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseVeriKontrol
{
    public static boolean databasedeMevcutmu(String sehir_adi)
    {
        SessionFactory sessionFactory= HavaDurumuSessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        Boolean donut;

        try
        {

            session.beginTransaction();

            HavaDurumu havaDurumuObjesi= (HavaDurumu)session.createQuery("from HavaDurumu h where h.sehir=?")
                    .setParameter(0,sehir_adi)
                    .getSingleResult();
            donut=true;

            session.getTransaction().commit();


        }
        catch (Exception e)
        {
            donut=false;
        }
        finally
        {
             session.close();
        }

        return donut;
    }
}
