package pl.spawalnik.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spawalnik.app.model.Welder;
import pl.spawalnik.app.repository.WelderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WelderServiceImpl implements WelderService {

    @Autowired
    private WelderRepository welderRepository;

    @Autowired
    private WelderService welderService;

    @Override
    public void save(Welder welder) {
        welderRepository.save(welder);
    }

    @Override
    public void delete(Long id) {
        welderRepository.delete(id);
    }

    @Override
    public Welder findById(Long id) {
        return welderRepository.findById(id);
    }

    @Override
    public List<Welder> findAll() {
        return welderRepository.findAll();
    }
}
