package aplikacja.crud.repozytorium;

import aplikacja.crud.pracownik.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepozytoriumPracownik extends JpaRepository<Pracownik, Integer> {
    boolean existsByNazwisko(String nazwisko);
}

