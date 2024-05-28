package aplikacja.crud.zwierze;
import aplikacja.crud.gatunek.Gatunek;
import aplikacja.crud.pracownik.Pracownik;
import aplikacja.crud.pawilon.Pawilon;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name="zwierze")
public class Zwierze implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_zwierzaka;

    @ManyToOne
    @JoinColumn(name="id_gatunku", referencedColumnName="id_gatunku")
    private Gatunek gatunek;

    @ManyToOne
    @JoinColumn(name="id_pawilonu", referencedColumnName="id_pawilonu")
    private Pawilon pawilon;

    @ManyToOne
    @JoinColumn(name="id_pracownika", referencedColumnName="id_pracownika")
    private Pracownik pracownik;

    @Column(name="imie")
    private String imie;

    @Column(name="wiekm")
    private BigInteger wiekM;

    @Column(name="plec")
    private String plec;

    public Zwierze() {}

    public Integer getId_zwierzaka() {
        return id_zwierzaka;
    }
    public void setId_zwierzaka(Integer id_zwierzaka) {
        this.id_zwierzaka = id_zwierzaka;
    }

    public Gatunek getGatunek() {return gatunek;}

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Pracownik getPracownik() {return pracownik;}

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }
    public BigInteger getWiekM() {
        return wiekM;
    }
    public void setWiekM(BigInteger wiekM) {
        this.wiekM = wiekM;
    }
    public String getPlec() {
        return plec;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Pawilon getPawilon() {return pawilon;}

    public void setPawilon(Pawilon pawilon) {
        this.pawilon = pawilon;
    }
}
