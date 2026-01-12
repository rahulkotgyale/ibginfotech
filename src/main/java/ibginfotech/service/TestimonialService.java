package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Testimonial;

public interface TestimonialService {
    Testimonial create(Testimonial testimonial);
    List<Testimonial> getAll();
    Testimonial getById(Long id);
    Testimonial update(Long id, Testimonial testimonial);
    void delete(Long id);
}
