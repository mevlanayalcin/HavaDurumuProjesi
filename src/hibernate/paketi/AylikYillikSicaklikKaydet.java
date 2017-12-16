package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AylikYillikSicaklikKaydet
{
    public  static void databaseVeriEkle(AylikYillikSicaklik aylikYillikSicaklik)
    {
        SessionFactory sessionFactory= AylikSicaklikSessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try
        {


            session.beginTransaction();

            System.out.println("AylikYillikSicaklik kaydediliyor");

            session.save(aylikYillikSicaklik);
            session.getTransaction().commit();

            System.out.println("AylikYillikSicaklik Basari Ile Kaydedildi !");


        }
        finally
        {
            session.close();
        }
    }
}
