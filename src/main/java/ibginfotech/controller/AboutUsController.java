package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(
            @RequestParam String heading,
            @RequestParam String content,
            @RequestParam String mission,
            @RequestParam String vision,
            @RequestParam MultipartFile image) {
        try {
            AboutUs about = new AboutUs();
            about.setHeading(heading);
            about.setContent(content);
            about.setMission(mission);
            about.setVision(vision);
            about.setImage(image.getBytes());

            return new ResponseEntity<>(service.create(about), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Image upload failed", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<AboutUs> list = service.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE with image
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestParam String heading,
            @RequestParam String content,
            @RequestParam String mission,
            @RequestParam String vision,
            @RequestParam MultipartFile image) {
        try {
            AboutUs about = new AboutUs();
            about.setHeading(heading);
            about.setContent(content);
            about.setMission(mission);
            about.setVision(vision);
            about.setImage(image.getBytes());

            return new ResponseEntity<>(service.update(id, about), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Image upload failed", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>("Deleted successfully with id " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Delete failed", HttpStatus.NOT_FOUND);
        }
    }

    // GET IMAGE BY ID
    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        try {
            byte[] image = service.getById(id).getImage();
            return new ResponseEntity<>(image, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Image not found", HttpStatus.NOT_FOUND);
        }
    }
}
