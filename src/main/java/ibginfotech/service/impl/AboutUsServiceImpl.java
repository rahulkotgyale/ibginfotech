package ibginfotech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibginfotech.entity.AboutUs;
import ibginfotech.repository.AboutUsRepository;
import ibginfotech.service.AboutUsService;

@Service
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private AboutUsRepository repo;

    // Create AboutUs (only one record allowed)
    @Override
    public AboutUs create(AboutUs aboutUs) {
        if (repo.count() > 0) {
            throw new RuntimeException("AboutUs already exists. Please update the existing record.");
        }
        return repo.save(aboutUs);
    }

    // Get all AboutUs records
    @Override
    public List<AboutUs> getAll() {
        return repo.findAll();
    }

    // Get AboutUs by ID
    @Override
    public AboutUs getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("AboutUs not found with id: " + id));
    }

    // Update AboutUs (null-safe update)
    @Override
    public AboutUs update(Long id, AboutUs aboutUs) {
        AboutUs existing = getById(id);

        if (aboutUs.getHeading() != null) {
            existing.setHeading(aboutUs.getHeading());
        }
        if (aboutUs.getContent() != null) {
            existing.setContent(aboutUs.getContent());
        }
        if (aboutUs.getMission() != null) {
            existing.setMission(aboutUs.getMission());
        }
        if (aboutUs.getVision() != null) {
            existing.setVision(aboutUs.getVision());
        }
        if (aboutUs.getImage() != null) {
            existing.setImage(aboutUs.getImage());
        }

        return repo.save(existing);
    }

    // Delete AboutUs by ID
    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Cannot delete. AboutUs not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
