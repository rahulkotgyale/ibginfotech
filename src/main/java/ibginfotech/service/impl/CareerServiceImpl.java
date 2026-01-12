package ibginfotech.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.Career;
import ibginfotech.repository.CareerRepository;
import ibginfotech.service.CareerService;

@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository repo;

    @Override
    public Career create(Career career) {
        career.setAppliedAt(LocalDateTime.now());
        return repo.save(career);
    }

    @Override
    public List<Career> getAll() {
        return repo.findAll();
    }

    @Override
    public Career getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Career not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
