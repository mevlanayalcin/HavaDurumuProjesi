package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseVeriCek
{
    public  static HavaDurumu databaseVeriGetir(String sehir)
    {
        SessionFactory sessionFactory= hibernate.paketi.SessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        HavaDurumu havaDurumu=null;


        try
        {

            session.beginTransaction();

            havaDurumu= (HavaDurumu) session.createQuery("from HavaDurumu  where sehir=?")
                    .setParameter(0,sehir)
                    .getSingleResult();


            session.getTransaction().commit();

            System.out.println("HavaDurumu bilgilerini databaseden web servise gönderdik agam!");


        }
        catch (Exception e)
        {
            System.out.println("Yolladığınız şehre ait hava durumu bulunamadı...");
            havaDurumu=null;
        }
        finally
        {
            session.close();
        }

        return  havaDurumu;
    }
}
