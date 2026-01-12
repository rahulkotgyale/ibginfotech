package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.Service;
import ibginfotech.service.ServiceService;

@RestController
@RequestMapping("/api/services")
@CrossOrigin("*")
public class ServiceController {

    @Autowired
    private ServiceService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public Service create(
            @RequestParam String serviceName,
            @RequestParam String description,
            @RequestParam String slug,
            @RequestParam MultipartFile icon) throws IOException {

        Service s = new Service();
        s.setServiceName(serviceName);
        s.setDescription(description);
        s.setSlug(slug);
        s.setIcon(icon.getBytes());

        return service.create(s);
    }

    // READ ALL
    @GetMapping
    public List<Service> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Service getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public Service update(
            @PathVariable Long id,
            @RequestParam String serviceName,
            @RequestParam String description,
            @RequestParam String slug,
            @RequestParam MultipartFile icon) throws IOException {

        Service s = new Service();
        s.setServiceName(serviceName);
        s.setDescription(description);
        s.setSlug(slug);
        s.setIcon(icon.getBytes());

        return service.update(id, s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Service deleted with id " + id;
    }

    // GET ICON
    @GetMapping("/{id}/icon")
    public byte[] getIcon(@PathVariable Long id) {
        return service.getById(id).getIcon();
    }
}
