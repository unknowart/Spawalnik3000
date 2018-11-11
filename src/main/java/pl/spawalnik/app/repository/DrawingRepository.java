package pl.spawalnik.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spawalnik.app.model.Drawing;

import java.util.List;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {
    List<Drawing> findAllByPipingSysId(Long id);

}
