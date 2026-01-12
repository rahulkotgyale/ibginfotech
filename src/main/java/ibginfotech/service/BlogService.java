package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Blog;

public interface BlogService {
    Blog create(Blog blog);
    List<Blog> getAll();
    Blog getById(Long id);
    Blog update(Long id, Blog blog);
    void delete(Long id);
}
