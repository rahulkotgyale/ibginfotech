package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Portfolio;

public interface PortfolioService {
    Portfolio create(Portfolio portfolio);
    List<Portfolio> getAll();
    Portfolio getById(Long id);
    Portfolio update(Long id, Portfolio portfolio);
    void delete(Long id);
}
