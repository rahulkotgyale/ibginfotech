package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.AboutUs;
import ibginfotech.service.AboutUsService;

@RestController
@RequestMapping("/api/about-us")
@CrossOrigin("*")
public class AboutUsController {

    @Autowired
    private AboutUsService service;

    // CREATE with image
    @PostMapping(consumes = "multipart/form-data")
    public AboutUs create(
            @RequestParam String heading,
            @RequestParam String content,
            @RequestParam String mission,
            @RequestParam String vision,
            @RequestParam MultipartFile image) throws IOException {

        AboutUs about = new AboutUs();
        about.setHeading(heading);
        about.setContent(content);
        about.setMission(mission);
        about.setVision(vision);
        about.setImage(image.getBytes());

        return service.create(about);
    }

    // READ ALL
    @GetMapping
    public List<AboutUs> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public AboutUs getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE with image
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public AboutUs update(
            @PathVariable Long id,
            @RequestParam String heading,
            @RequestParam String content,
            @RequestParam String mission,
            @RequestParam String vision,
            @RequestParam MultipartFile image) throws IOException {

        AboutUs about = new AboutUs();
        about.setHeading(heading);
        about.setContent(content);
        about.setMission(mission);
        about.setVision(vision);
        about.setImage(image.getBytes());

        return service.update(id, about);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully with id " + id;
    }

    // GET IMAGE BY ID
    @GetMapping("/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        return service.getById(id).getImage();
    }
}
