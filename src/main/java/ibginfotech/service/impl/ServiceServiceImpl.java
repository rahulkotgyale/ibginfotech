package ibginfotech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibginfotech.repository.ServiceRepository;
import ibginfotech.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository repo;

    @Override
    public List<ibginfotech.entity.Service> getAll() {
        return repo.findAll();
    }

    @Override
    public ibginfotech.entity.Service getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id " + id));
    }

    @Override
    public ibginfotech.entity.Service create(ibginfotech.entity.Service service) {
        if (repo.existsBySlug(service.getSlug())) {
            throw new RuntimeException("Slug already exists");
        }
        return repo.save(service);
    }

    @Override
    public ibginfotech.entity.Service update(Long id, ibginfotech.entity.Service service) {
    	ibginfotech.entity.Service existing = getById(id);
        existing.setServiceName(service.getServiceName());
        existing.setDescription(service.getDescription());
        existing.setSlug(service.getSlug());
        existing.setIcon(service.getIcon());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
