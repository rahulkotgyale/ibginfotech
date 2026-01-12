package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
