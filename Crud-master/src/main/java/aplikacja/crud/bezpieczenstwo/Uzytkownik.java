package aplikacja.crud.bezpieczenstwo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;



@Entity
@Table(name = "uzytkownik")
public class Uzytkownik implements Serializable{

    @Id
    private Integer id;
    @Column(name="imie")
    private String username;
    @Column(name="haslo")
    private String password;
    @Column(name="role")
    private String role; // Role mogą być zapisane jako string oddzielony przecinkami

    // Gettery i settery

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public String getRole() {
        return role;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
//    public void setId(String id) {
//        this.id = id;
//    }
}
