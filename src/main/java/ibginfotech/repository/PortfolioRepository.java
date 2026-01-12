package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
