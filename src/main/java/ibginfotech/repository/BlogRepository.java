package ibginfotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibginfotech.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    boolean existsBySlug(String slug);
}
