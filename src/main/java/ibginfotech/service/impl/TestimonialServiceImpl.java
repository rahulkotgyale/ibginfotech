package ibginfotech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibginfotech.entity.Testimonial;
import ibginfotech.repository.TestimonialRepository;
import ibginfotech.service.TestimonialService;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository repo;

    @Override
    public Testimonial create(Testimonial testimonial) {
        return repo.save(testimonial);
    }

    @Override
    public List<Testimonial> getAll() {
        return repo.findAll();
    }

    @Override
    public Testimonial getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with id " + id));
    }

    @Override
    public Testimonial update(Long id, Testimonial testimonial) {
        Testimonial existing = getById(id);
        existing.setClientName(testimonial.getClientName());
        existing.setCompany(testimonial.getCompany());
        existing.setMessage(testimonial.getMessage());
        existing.setRating(testimonial.getRating());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
