package ibginfotech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ibginfotech.entity.Blog;
import ibginfotech.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private BlogService service;

    // CREATE
    @PostMapping(consumes = "multipart/form-data")
    public Blog create(
            @RequestParam String title,
            @RequestParam String slug,
            @RequestParam String content,
            @RequestParam String author,
            @RequestParam MultipartFile image) throws IOException {

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setSlug(slug);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setImage(image.getBytes());

        return service.create(blog);
    }

    // READ ALL
    @GetMapping
    public List<Blog> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Blog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public Blog update(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String slug,
            @RequestParam String content,
            @RequestParam String author,
            @RequestParam MultipartFile image) throws IOException {

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setSlug(slug);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setImage(image.getBytes());

        return service.update(id, blog);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Blog deleted with id " + id;
    }

    // GET IMAGE
    @GetMapping("/{id}/image")
    public byte[] getImage(@PathVariable Long id) {
        return service.getById(id).getImage();
    }
}
