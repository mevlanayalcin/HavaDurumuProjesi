package hibernate.paketi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseVeriUpdate {
    public  static void databaseUpdate(HavaDurumu havaDurumu)
    {
        SessionFactory sessionFactory= hibernate.paketi.SessionFactorySingleton.getSessionFactory();

        Session session=sessionFactory.getCurrentSession();



        try
        {

            session.beginTransaction();

            session.createQuery("update HavaDurumu  set durum=?, sicaklik=?, basinc=?, nem_orani=? where sehir=?")
                    .setParameter(0,havaDurumu.getDurum())
                    .setParameter(1,havaDurumu.getSicaklik())
                    .setParameter(2,havaDurumu.getBasinc())
                    .setParameter(3,havaDurumu.getNem_orani())
                    .setParameter(4,havaDurumu.getSehir())
                    .executeUpdate();


            session.getTransaction().commit();
            System.out.println("HavaDurumu bilgilerini update ettik agam sorunumuz yok !");


        }
        finally
        {
            session.close();
        }
    }
}
