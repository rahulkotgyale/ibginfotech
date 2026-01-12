package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
