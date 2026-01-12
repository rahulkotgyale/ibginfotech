package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Home;

public interface HomeRepository extends JpaRepository<Home, Long> {
}
