package ibginfotech.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.ContactMessage;
import ibginfotech.repository.ContactMessageRepository;
import ibginfotech.service.ContactMessageService;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    @Autowired
    private ContactMessageRepository repo;

    @Override
    public ContactMessage create(ContactMessage msg) {
        msg.setCreatedAt(LocalDateTime.now());
        return repo.save(msg);
    }

    @Override
    public List<ContactMessage> getAll() {
        return repo.findAll();
    }

    @Override
    public ContactMessage getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
