package pl.spawalnik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spawalnik.app.model.Weld;
import pl.spawalnik.app.model.Wps;
import pl.spawalnik.app.repository.WeldRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WeldServiceImpl implements WeldService {
    @Autowired
    private WeldRepository weldRepository;

    @Override
    public void save(Weld weld) {
        weldRepository.save(weld);
    }

    @Override
    public void delete(Long id) {
        weldRepository.delete(id);
    }

    @Override
    public Weld findById(Long id) {
        return null;
    }


    @Override
    public List<Weld> findAll() {
        return weldRepository.findAll();
    }

    @Override
    public List<Weld> findAllByDrawingId(Long id) {
        return weldRepository.findAllByDrawingId(id);
    }

    @Override
    public List<Weld> findAllBySystemId(Long id) {
        return weldRepository.findAllByPipingSysId(id);
    }

    @Override
    public List<Weld> findAllByRtBySystem(Long id) {
        return weldRepository.findAllByRtBySystem(id);
    }

    @Override
    public List<Weld> findAllByPtBySystem(Long id) {
        return weldRepository.findAllByPtBySystem(id);
    }


}
