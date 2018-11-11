package pl.spawalnik.app.service;

import pl.spawalnik.app.model.Welder;

import java.util.List;

public interface WelderService {
    void save(Welder welder);
    void delete(Long id);
    Welder findById(Long id);
    List<Welder> findAll();
}
