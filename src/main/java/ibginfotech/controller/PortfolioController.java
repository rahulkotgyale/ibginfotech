package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.Portfolio;
import ibginfotech.service.PortfolioService;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin("*")
public class PortfolioController {

    @Autowired
    private PortfolioService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public Portfolio create(
            @RequestParam String projectName,
            @RequestParam String clientName,
            @RequestParam String description,
            @RequestParam MultipartFile image,
            @RequestParam String techStack,
            @RequestParam String projectUrl) throws IOException {

        Portfolio p = new Portfolio();
        p.setProjectName(projectName);
        p.setClientName(clientName);
        p.setDescription(description);
        p.setImage(image.getBytes());
        p.setTechStack(techStack);
        p.setProjectUrl(projectUrl);

        return service.create(p);
    }

    // READ ALL
    @GetMapping
    public List<Portfolio> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Portfolio getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public Portfolio update(
            @PathVariable Long id,
            @RequestParam String projectName,
            @RequestParam String clientName,
            @RequestParam String description,
            @RequestParam MultipartFile image,
            @RequestParam String techStack,
            @RequestParam String projectUrl) throws IOException {

        Portfolio p = new Portfolio();
        p.setProjectName(projectName);
        p.setClientName(clientName);
        p.setDescription(description);
        p.setImage(image.getBytes());
        p.setTechStack(techStack);
        p.setProjectUrl(projectUrl);

        return service.update(id, p);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Portfolio deleted with id " + id;
    }

    // GET IMAGE
    @GetMapping("/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        return service.getById(id).getImage();
    }
}
