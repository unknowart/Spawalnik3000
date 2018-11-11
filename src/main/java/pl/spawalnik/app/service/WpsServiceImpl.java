package pl.spawalnik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Wps;
import pl.spawalnik.app.repository.WpsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WpsServiceImpl implements WpsService {

    @Autowired
    private WpsRepository wpsRepository;

    @Override
    public void save(Wps wps) {
        wpsRepository.save(wps);
    }

    @Override
    public void delete(Long id) {
        wpsRepository.delete(id);
    }

    @Override
    public Wps findById(Long id) {
        return wpsRepository.findOne(id);
    }

    @Override
    public List<Wps> findAll() {
        return wpsRepository.findAll();
    }

    @Override
    public List<Wps> findByDiameter(double dia) {
        return wpsRepository.findByDiameter(dia);
    }
}
