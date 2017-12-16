package hibernate.paketi;

import javax.persistence.*;

@Entity
@Table(name="sicaklik_tablosu")
public class AylikYillikSicaklik
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sehir")
    private String sehir;

    @Column(name = "ocak")
    private long ocak;

    @Column(name = "subat")
    private long subat;

    @Column(name = "mart")
    private long mart;

    @Column(name = "nisan")
    private long nisan;

    @Column(name = "mayis")
    private long mayis;

    @Column(name = "haziran")
    private long haziran;

    @Column(name = "temmuz")
    private long temmuz;

    @Column(name = "agustos")
    private long agustos;

    @Column(name = "eylul")
    private long eylul;

    @Column(name = "ekim")
    private long ekim;

    @Column(name = "kasim")
    private long kasim;

    @Column(name = "aralik")
    private long aralik;

    @Column(name = "yillik")
    private long yillik;

    public AylikYillikSicaklik()
    {
    }

    public AylikYillikSicaklik(String sehir, long ocak, long subat, long mart, long nisan, long mayis, long haziran, long temmuz, long agustos, long eylul, long ekim, long kasim, long aralik, long yillik) {
        this.sehir = sehir;
        this.ocak = ocak;
        this.subat = subat;
        this.mart = mart;
        this.nisan = nisan;
        this.mayis = mayis;
        this.haziran = haziran;
        this.temmuz = temmuz;
        this.agustos = agustos;
        this.eylul = eylul;
        this.ekim = ekim;
        this.kasim = kasim;
        this.aralik = aralik;
        this.yillik = yillik;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public long getOcak() {
        return ocak;
    }

    public void setOcak(long ocak) {
        this.ocak = ocak;
    }

    public long getSubat() {
        return subat;
    }

    public void setSubat(long subat) {
        this.subat = subat;
    }

    public long getMart() {
        return mart;
    }

    public void setMart(long mart) {
        this.mart = mart;
    }

    public long getNisan() {
        return nisan;
    }

    public void setNisan(long nisan) {
        this.nisan = nisan;
    }

    public long getMayis() {
        return mayis;
    }

    public void setMayis(long mayis) {
        this.mayis = mayis;
    }

    public long getHaziran() {
        return haziran;
    }

    public void setHaziran(long haziran) {
        this.haziran = haziran;
    }

    public long getTemmuz() {
        return temmuz;
    }

    public void setTemmuz(long temmuz) {
        this.temmuz = temmuz;
    }

    public long getAgustos() {
        return agustos;
    }

    public void setAgustos(long agustos) {
        this.agustos = agustos;
    }

    public long getEylul() {
        return eylul;
    }

    public void setEylul(long eylul) {
        this.eylul = eylul;
    }

    public long getEkim() {
        return ekim;
    }

    public void setEkim(long ekim) {
        this.ekim = ekim;
    }

    public long getKasim() {
        return kasim;
    }

    public void setKasim(long kasim) {
        this.kasim = kasim;
    }

    public long getAralik() {
        return aralik;
    }

    public void setAralik(long aralik) {
        this.aralik = aralik;
    }

    public long getYillik() {
        return yillik;
    }

    public void setYillik(long yillik) {
        this.yillik = yillik;
    }

    @Override
    public String toString() {
        return "AylikYillikSicaklik{" +
                "id=" + id +
                ", sehir='" + sehir + '\'' +
                ", ocak=" + ocak +
                ", subat=" + subat +
                ", mart=" + mart +
                ", nisan=" + nisan +
                ", mayis=" + mayis +
                ", haziran=" + haziran +
                ", temmuz=" + temmuz +
                ", agustos=" + agustos +
                ", eylul=" + eylul +
                ", ekim=" + ekim +
                ", kasim=" + kasim +
                ", aralik=" + aralik +
                ", yillik=" + yillik +
                '}';
    }
}
