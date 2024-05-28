package aplikacja.crud.pawilon;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pawilon")
public class Pawilon implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pawilonu;

    @Column(name="nazwa")
    private String nazwa;

    public Pawilon(){}

    public Pawilon (String nazwa){
    this.nazwa = nazwa;
    }

    public Integer getId_pawilonu() {
        return id_pawilonu;
    }

    public void setId_pawilonu(Integer id_pawilonu) {
        this.id_pawilonu = id_pawilonu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}

