package ibginfotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibginfotech.entity.ContactMessage;
import ibginfotech.service.ContactMessageService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactMessageController {

    @Autowired
    private ContactMessageService service;

    // CREATE
    @PostMapping
    public ContactMessage create(@RequestBody ContactMessage msg) {
        return service.create(msg);
    }

    // READ ALL
    @GetMapping
    public List<ContactMessage> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ContactMessage getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted message with id " + id;
    }
}
