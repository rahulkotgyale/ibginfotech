package ibginfotech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.AboutUs;
import ibginfotech.repository.AboutUsRepository;
import ibginfotech.service.AboutUsService;

@Service
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private AboutUsRepository repo;

    @Override
    public AboutUs create(AboutUs aboutUs) {
        return repo.save(aboutUs);
    }

    @Override
    public List<AboutUs> getAll() {
        return repo.findAll();
    }

    @Override
    public AboutUs getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("AboutUs not found with id " + id));
    }

    @Override
    public AboutUs update(Long id, AboutUs aboutUs) {
        AboutUs existing = getById(id);
        existing.setHeading(aboutUs.getHeading());
        existing.setContent(aboutUs.getContent());
        existing.setMission(aboutUs.getMission());
        existing.setVision(aboutUs.getVision());
        existing.setImage(aboutUs.getImage());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
