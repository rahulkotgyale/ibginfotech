package ibginfotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibginfotech.entity.Faq;
import ibginfotech.service.FaqService;

@RestController
@RequestMapping("/api/faqs")
@CrossOrigin("*")
public class FaqController {

    @Autowired
    private FaqService service;

    // CREATE
    @PostMapping
    public Faq create(@RequestBody Faq faq) {
        return service.create(faq);
    }

    // READ ALL
    @GetMapping
    public List<Faq> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Faq getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Faq update(@PathVariable Long id, @RequestBody Faq faq) {
        return service.update(id, faq);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Faq deleted with id " + id;
    }
}
