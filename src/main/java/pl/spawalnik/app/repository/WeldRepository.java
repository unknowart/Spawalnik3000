package pl.spawalnik.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Wps;

import java.util.List;

public interface WeldRepository extends JpaRepository<Weld, Long> {
    List<Weld> findAllByDrawingId(Long id);
    List<Weld> findAllByPipingSysId(Long id);
    List<Weld> findAllByWelderId(Long id);

    @Query("select w from Weld w where w.pipingSys.id = ?1 and w.rtNdt like '%RT%'")
    List<Weld> findAllByRtBySystem(Long id);

    @Query("select w from Weld w where w.pipingSys.id = ?1 and w.ptNdt like '%PT%'")
    List<Weld> findAllByPtBySystem(Long id);


}
