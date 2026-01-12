package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.ContactMessage;

public interface ContactMessageService {
    ContactMessage create(ContactMessage msg);
    List<ContactMessage> getAll();
    ContactMessage getById(Long id);
    void delete(Long id);
}
