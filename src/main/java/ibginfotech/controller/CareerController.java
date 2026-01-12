package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.Career;
import ibginfotech.service.CareerService;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin("*")
public class CareerController {

    @Autowired
    private CareerService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public Career create(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String position,
            @RequestParam String experience,
            @RequestParam String message,
            @RequestParam MultipartFile resume) throws IOException {

        Career career = new Career();
        career.setFullName(fullName);
        career.setEmail(email);
        career.setPhone(phone);
        career.setPosition(position);
        career.setExperience(experience);
        career.setMessage(message);
        career.setResume(resume.getBytes());

        return service.create(career);
    }

    // READ ALL
    @GetMapping
    public List<Career> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Career getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted career with id " + id;
    }

    // GET RESUME
    @GetMapping("/{id}/resume")
    public byte[] getResume(@PathVariable Long id) {
        return service.getById(id).getResume();
    }
}
