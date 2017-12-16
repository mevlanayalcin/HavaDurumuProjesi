package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class HavaDurumuVerisiGetir
{
    public  static List<HavaDurumu> databaseVeriGetir(String sehir)
    {
        SessionFactory sessionFactory= HavaDurumuSessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        List<HavaDurumu>havaDurumuList=null;



        try
        {
            havaDurumuList=new ArrayList<>();
            session.beginTransaction();

            havaDurumuList=  session.createQuery("from HavaDurumu  where sehir=?")
                    .setParameter(0,sehir)
                    .getResultList();


            session.getTransaction().commit();

            System.out.println("HavaDurumu bilgilerini liste olarak databaseden aldık agam!");



        }
        catch (Exception e)
        {
            System.out.println("Yolladığınız şehre ait hava durumu bulunamadı...");
            havaDurumuList=null;
        }
        finally
        {
            session.close();
        }

        return  havaDurumuList;
    }

    public static void main(String[] args)
    {
        List<HavaDurumu>havaDurumuList=new ArrayList<>();
        havaDurumuList= HavaDurumuVerisiGetir.databaseVeriGetir("ankara");

        for(HavaDurumu havaDurumu:havaDurumuList)
        {
            System.out.println(havaDurumu);
        }
    }
}
