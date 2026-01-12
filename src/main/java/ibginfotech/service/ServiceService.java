package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Service;

public interface ServiceService {
    List<Service> getAll();
    ibginfotech.entity.Service getById(Long id);
    ibginfotech.entity.Service create(Service service);
    ibginfotech.entity.Service update(Long id, Service service);
    void delete(Long id);
}
