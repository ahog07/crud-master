package aplikacja.crud.repozytorium;

import aplikacja.crud.bezpieczenstwo.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepozytoriumUzytkownik extends JpaRepository<Uzytkownik, Integer> {
    Uzytkownik findByUsername(String username);
}

