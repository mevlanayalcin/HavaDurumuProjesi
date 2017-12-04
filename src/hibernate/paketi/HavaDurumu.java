package hibernate.paketi;

import javax.persistence.*;

@Entity
@Table(name="hava_durumu")
public class HavaDurumu
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sehir")
    private String sehir;

    @Column(name = "durum")
    private String durum;

    @Column(name = "sicaklik")
    private long sicaklik;

    @Column(name = "basinc")
    private long basinc;

    @Column(name = "nem_orani")
    private long nem_orani;


    public HavaDurumu()
    {

    }

    public HavaDurumu(String sehir, String durum, long sicaklik, long basinc, long nem_orani)
    {
        this.sehir = sehir;
        this.durum = durum;
        this.sicaklik = sicaklik;
        this.basinc = basinc;
        this.nem_orani = nem_orani;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSehir()
    {
        return sehir;
    }

    public void setSehir(String sehir)
    {
        this.sehir = sehir;
    }

    public String getDurum()
    {
        return durum;
    }

    public void setDurum(String durum)
    {
        this.durum = durum;
    }

    public long getSicaklik()
    {
        return sicaklik;
    }

    public void setSicaklik(long sicaklik)
    {
        this.sicaklik = sicaklik;
    }

    public long getBasinc()
    {
        return basinc;
    }

    public void setBasinc(long basinc)
    {
        this.basinc = basinc;
    }

    public long getNem_orani()
    {
        return nem_orani;
    }

    public void setNem_orani(long nem_orani)
    {
        this.nem_orani = nem_orani;
    }

    @Override
    public String toString()
    {
        return "HavaDurumu{" +
                "id=" + id +
                ", sehir='" + sehir + '\'' +
                ", durum='" + durum + '\'' +
                ", sicaklik=" + sicaklik +
                ", basinc=" + basinc +
                ", nem_orani=" + nem_orani +
                '}';
    }
}
