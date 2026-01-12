package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Home;

public interface HomeService {
    Home create(Home home);
    List<Home> getAll();
    Home getById(Long id);
    Home update(Long id, Home home);
    void delete(Long id);
}
