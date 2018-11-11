package pl.spawalnik.app.service;

import pl.spawalnik.app.model.PipingSys;

import java.util.List;

public interface PipingSysService {
    void save(PipingSys pipingSys);
    void delete(Long id);
    PipingSys findById(Long id);
    List<PipingSys> findAll();
}
