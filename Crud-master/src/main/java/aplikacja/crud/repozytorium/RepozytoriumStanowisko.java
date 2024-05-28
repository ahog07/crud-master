package aplikacja.crud.repozytorium;

import aplikacja.crud.stanowisko.Stanowisko;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepozytoriumStanowisko extends JpaRepository<Stanowisko, Integer> {
    boolean existsByNazwa(String nazwa);
}
