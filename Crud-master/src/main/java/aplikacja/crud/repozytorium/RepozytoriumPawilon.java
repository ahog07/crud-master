package aplikacja.crud.repozytorium;

import aplikacja.crud.pawilon.Pawilon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepozytoriumPawilon extends JpaRepository<Pawilon, Integer> {
    boolean existsByNazwa(String nazwa);
}
