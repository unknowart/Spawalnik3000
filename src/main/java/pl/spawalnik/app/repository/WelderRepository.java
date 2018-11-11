package pl.spawalnik.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spawalnik.app.model.Welder;

public interface WelderRepository extends JpaRepository<Welder, Long> {
    Welder findById(Long id);

}
