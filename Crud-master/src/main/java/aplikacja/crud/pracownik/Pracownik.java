package aplikacja.crud.pracownik;

import aplikacja.crud.stanowisko.Stanowisko;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pracownik")
public class Pracownik implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pracownika;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    @ManyToOne
    @JoinColumn(name="id_stanowiska", referencedColumnName="id_stanowiska")
    private Stanowisko stanowisko;

    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="data_zatrudnienia")
    @Temporal(TemporalType.DATE)
    private Date data_zatrudnienia;


    public Pracownik() {}


    public Integer getId_pracownika() {
        return id_pracownika;
    }
    public void setId_pracownika(Integer id_pracownika) {
        this.id_pracownika = id_pracownika;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Stanowisko getStanowisko() {return stanowisko;}

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }
    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }
    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }


}
