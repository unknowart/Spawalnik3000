package pl.spawalnik.app.service;

import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Wps;

import java.util.List;

public interface WpsService {
    void save(Wps wps);
    void delete(Long id);
    Wps findById(Long id);
    List<Wps> findAll();
    List<Wps> findByDiameter(double dia);
}
