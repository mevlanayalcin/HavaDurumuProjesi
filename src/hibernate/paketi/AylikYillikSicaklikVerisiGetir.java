package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AylikYillikSicaklikVerisiGetir
{
    public  static AylikYillikSicaklik databaseVeriGetir(String sehir)
    {
        SessionFactory sessionFactory= AylikSicaklikSessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        AylikYillikSicaklik aylikSicaklik=null;



        try
        {

            session.beginTransaction();

            aylikSicaklik= (AylikYillikSicaklik) session.createQuery("from AylikYillikSicaklik  where sehir=?")
                    .setParameter(0,sehir)
                    .getSingleResult();


            session.getTransaction().commit();

            System.out.println("AylikYillikSicaklik bilgisini  databaseden aldık agam!");



        }
        catch (Exception e)
        {
            System.out.println("Yolladığınız şehre ait AylikYillikSicaklik bulunamadı...");
            aylikSicaklik=null;
        }
        finally
        {
            session.close();
        }

        return  aylikSicaklik;
    }

    public static void main(String[] args)
    {
        System.out.println(AylikYillikSicaklikVerisiGetir.databaseVeriGetir("ANKARA"));
    }
}
