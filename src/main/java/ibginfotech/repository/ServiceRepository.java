package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    boolean existsBySlug(String slug);

}
