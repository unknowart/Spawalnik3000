package pl.spawalnik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spawalnik.app.model.PipingSys;
import pl.spawalnik.app.repository.PipingSysRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PipingSysServiceImpl implements PipingSysService {

    @Autowired
    private PipingSysRepository pipingSysRepository;

    @Override
    public void save(PipingSys pipingSys) {
        pipingSysRepository.save(pipingSys);
    }

    @Override
    public void delete(Long id) {
        pipingSysRepository.delete(id);
    }

    @Override
    public PipingSys findById(Long id) {
        return pipingSysRepository.findOne(id);
    }

    @Override
    public List<PipingSys> findAll() {
        return pipingSysRepository.findAll();
    }
}
