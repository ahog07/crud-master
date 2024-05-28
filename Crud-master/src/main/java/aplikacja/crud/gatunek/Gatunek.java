package aplikacja.crud.gatunek;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="gatunek")
public class Gatunek implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gatunku;

    @Column(name="nazwa")
    private String nazwa;

    public Gatunek(){}

    public Gatunek (String nazwa){
        this.nazwa = nazwa;
    }
    public Integer getId_gatunku() {
        return id_gatunku;
    }
    public void setId_gatunku(Integer id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}


