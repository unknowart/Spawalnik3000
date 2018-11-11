package pl.spawalnik.app.service;

import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Wps;

import java.util.List;

public interface WeldService {
    void save(Weld weld);
    void delete(Long id);
    Weld findById(Long id);
    List<Weld> findAll();
    List<Weld> findAllByDrawingId(Long id);

    List<Weld> findAllBySystemId(Long id);

    List<Weld> findAllByRtBySystem(Long id);

    List<Weld> findAllByPtBySystem(Long id);
}
