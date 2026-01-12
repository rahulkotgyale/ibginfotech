package ibginfotech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.Home;
import ibginfotech.repository.HomeRepository;
import ibginfotech.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository repo;

    @Override
    public Home create(Home home) {
        return repo.save(home);
    }

    @Override
    public List<Home> getAll() {
        return repo.findAll();
    }

    @Override
    public Home getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Home not found with id " + id));
    }

    @Override
    public Home update(Long id, Home home) {
        Home existing = getById(id);
        existing.setBannerTitle(home.getBannerTitle());
        existing.setBannerSubtitle(home.getBannerSubtitle());
        existing.setButtonText(home.getButtonText());
        existing.setButtonLink(home.getButtonLink());
        existing.setBannerImage(home.getBannerImage());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
