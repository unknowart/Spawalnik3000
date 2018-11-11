package pl.spawalnik.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.spawalnik.app.model.Wps;

import java.util.List;

public interface WpsRepository extends JpaRepository<Wps, Long> {

    @Query("select w from Wps w where w.maxDiameter > ?1 and w.minDiameter < ?1")
    List<Wps> findByDiameter(double dia);

}
