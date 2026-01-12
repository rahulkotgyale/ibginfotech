package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.Home;
import ibginfotech.service.HomeService;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("*")
public class HomeController {

    @Autowired
    private HomeService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public Home create(
            @RequestParam String bannerTitle,
            @RequestParam String bannerSubtitle,
            @RequestParam String buttonText,
            @RequestParam String buttonLink,
            @RequestParam MultipartFile bannerImage) throws IOException {

        Home home = new Home();
        home.setBannerTitle(bannerTitle);
        home.setBannerSubtitle(bannerSubtitle);
        home.setButtonText(buttonText);
        home.setButtonLink(buttonLink);
        home.setBannerImage(bannerImage.getBytes());

        return service.create(home);
    }

    // READ ALL
    @GetMapping
    public List<Home> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Home getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public Home update(
            @PathVariable Long id,
            @RequestParam String bannerTitle,
            @RequestParam String bannerSubtitle,
            @RequestParam String buttonText,
            @RequestParam String buttonLink,
            @RequestParam MultipartFile bannerImage) throws IOException {

        Home home = new Home();
        home.setBannerTitle(bannerTitle);
        home.setBannerSubtitle(bannerSubtitle);
        home.setButtonText(buttonText);
        home.setButtonLink(buttonLink);
        home.setBannerImage(bannerImage.getBytes());

        return service.update(id, home);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Home deleted with id " + id;
    }

    // GET IMAGE
    @GetMapping("/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        return service.getById(id).getBannerImage();
    }
}
