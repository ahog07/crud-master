package aplikacja.crud.repozytorium;

import aplikacja.crud.gatunek.Gatunek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepozytoriumGatunek extends JpaRepository<Gatunek, Integer> {
    boolean existsByNazwa(String nazwa);
}


