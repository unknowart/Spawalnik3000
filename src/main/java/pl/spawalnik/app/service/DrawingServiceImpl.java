package pl.spawalnik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spawalnik.app.model.Drawing;
import pl.spawalnik.app.repository.DrawingRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrawingServiceImpl implements DrawingService {
    @Autowired
    private DrawingRepository drawingRepository;

    @Override
    public void save(Drawing drawing) {
        drawingRepository.save(drawing);
    }

    @Override
    public void delete(Long id) {
        drawingRepository.delete(id);
    }

    @Override
    public Drawing findById(Long id) {
        return drawingRepository.findOne(id);
    }

    @Override
    public List<Drawing> findAll() {
        return drawingRepository.findAll();
    }

    @Override
    public List<Drawing> findAllFromSystem(Long id) {
        return drawingRepository.findAllByPipingSysId(id);
    }
}
