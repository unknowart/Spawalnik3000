package pl.spawalnik.app.service;

import pl.spawalnik.app.model.Drawing;

import java.util.List;

public interface DrawingService {
    void save(Drawing drawing);
    void delete(Long id);
    Drawing findById(Long id);
    List<Drawing> findAll();
    List<Drawing> findAllFromSystem(Long id);

}
