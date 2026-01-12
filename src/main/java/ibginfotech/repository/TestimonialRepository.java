package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
}
