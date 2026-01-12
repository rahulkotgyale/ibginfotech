package ibginfotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibginfotech.entity.Testimonial;
import ibginfotech.service.TestimonialService;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin("*")
public class TestimonialController {

    @Autowired
    private TestimonialService service;

    // CREATE
    @PostMapping
    public Testimonial create(@RequestBody Testimonial testimonial) {
        return service.create(testimonial);
    }

    // READ ALL
    @GetMapping
    public List<Testimonial> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Testimonial getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Testimonial update(@PathVariable Long id, @RequestBody Testimonial testimonial) {
        return service.update(id, testimonial);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Testimonial deleted with id " + id;
    }
}
