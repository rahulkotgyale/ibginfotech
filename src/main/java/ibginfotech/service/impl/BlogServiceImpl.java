package ibginfotech.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.Blog;
import ibginfotech.repository.BlogRepository;
import ibginfotech.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository repo;

    @Override
    public Blog create(Blog blog) {
        if (repo.existsBySlug(blog.getSlug())) {
            throw new RuntimeException("Slug already exists");
        }
        blog.setPublishedAt(LocalDateTime.now());
        return repo.save(blog);
    }

    @Override
    public List<Blog> getAll() {
        return repo.findAll();
    }

    @Override
    public Blog getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }

    @Override
    public Blog update(Long id, Blog blog) {
        Blog existing = getById(id);
        existing.setTitle(blog.getTitle());
        existing.setSlug(blog.getSlug());
        existing.setContent(blog.getContent());
        existing.setImage(blog.getImage());
        existing.setAuthor(blog.getAuthor());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
