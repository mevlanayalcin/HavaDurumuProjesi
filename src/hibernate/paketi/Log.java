package hibernate.paketi;

import javax.persistence.*;

@Entity
@Table(name="log_tablosu")
public class Log
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "IP")
    private String ip;

    @Column(name = "DATE")
    private String date;

    @Column(name = "REQUEST_URL")
    private String reqUrl;

    public Log() {
    }

    public Log(String ip, String date, String reqUrl) {
        this.ip = ip;
        this.date = date;
        this.reqUrl = reqUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", date='" + date + '\'' +
                ", reqUrl='" + reqUrl + '\'' +
                '}';
    }
}
