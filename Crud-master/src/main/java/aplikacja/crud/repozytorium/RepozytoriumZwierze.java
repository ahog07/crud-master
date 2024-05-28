package aplikacja.crud.repozytorium;

import aplikacja.crud.zwierze.Zwierze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepozytoriumZwierze extends JpaRepository<Zwierze, Integer> {
}
