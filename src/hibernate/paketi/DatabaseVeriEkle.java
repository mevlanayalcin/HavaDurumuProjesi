package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseVeriEkle {
    public  static void databaseVeriEkle(HavaDurumu havaDurumu)
    {
        SessionFactory sessionFactory= hibernate.paketi.SessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try
        {

            System.out.println("Yeni durum olusturuyoruz");



            session.beginTransaction();

            System.out.println("Durum kaydediliyor");

            session.save(havaDurumu);
            session.getTransaction().commit();

            System.out.println("Hava Durumu Basari Ile Kaydedildi !");


        }
        finally
        {
            session.close();
        }
    }
}
