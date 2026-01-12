package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
