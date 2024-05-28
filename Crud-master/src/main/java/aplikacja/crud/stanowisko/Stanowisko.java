package aplikacja.crud.stanowisko;

import jakarta.persistence.*;
import java.io.Serializable;
import aplikacja.crud.pracownik.Pracownik;

@Entity
@Table(name="stanowisko")
public class Stanowisko implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_stanowiska;


    @Column(name="nazwa")
    private String nazwa;

    public Stanowisko(){}

    public Stanowisko(String nazwa){
        this.nazwa = nazwa;
    }
    public Integer getId_stanowiska() {return id_stanowiska;}
    public void setId_stanowiska(Integer id_stanowiska) {this.id_stanowiska = id_stanowiska;}

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}

