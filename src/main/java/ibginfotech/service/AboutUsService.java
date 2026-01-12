package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.AboutUs;

public interface AboutUsService {
    AboutUs create(AboutUs aboutUs);
    List<AboutUs> getAll();
    AboutUs getById(Long id);
    AboutUs update(Long id, AboutUs aboutUs);
    void delete(Long id);
}
