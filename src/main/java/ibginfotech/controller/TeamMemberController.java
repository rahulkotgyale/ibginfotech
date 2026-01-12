package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.TeamMember;
import ibginfotech.service.TeamMemberService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin("*")
public class TeamMemberController {

    @Autowired
    private TeamMemberService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public TeamMember create(
            @RequestParam String name,
            @RequestParam String position,
            @RequestParam String bio,
            @RequestParam MultipartFile photo,
            @RequestParam String linkedin,
            @RequestParam String twitter) throws IOException {

        TeamMember m = new TeamMember();
        m.setName(name);
        m.setPosition(position);
        m.setBio(bio);
        m.setPhoto(photo.getBytes());
        m.setLinkedin(linkedin);
        m.setTwitter(twitter);

        return service.create(m);
    }

    // READ ALL
    @GetMapping
    public List<TeamMember> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public TeamMember getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public TeamMember update(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String position,
            @RequestParam String bio,
            @RequestParam MultipartFile photo,
            @RequestParam String linkedin,
            @RequestParam String twitter) throws IOException {

        TeamMember m = new TeamMember();
        m.setName(name);
        m.setPosition(position);
        m.setBio(bio);
        m.setPhoto(photo.getBytes());
        m.setLinkedin(linkedin);
        m.setTwitter(twitter);

        return service.update(id, m);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Team member deleted with id " + id;
    }

    // GET PHOTO
    @GetMapping("/{id}/photo")
    public byte[] getPhoto(@PathVariable Long id) {
        return service.getById(id).getPhoto();
    }
}
