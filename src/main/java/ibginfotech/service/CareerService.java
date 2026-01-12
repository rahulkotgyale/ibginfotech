package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Career;

public interface CareerService {
    Career create(Career career);
    List<Career> getAll();
    Career getById(Long id);
    void delete(Long id);
}
