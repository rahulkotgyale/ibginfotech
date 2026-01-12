package ibginfotech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.Portfolio;
import ibginfotech.repository.PortfolioRepository;
import ibginfotech.service.PortfolioService;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository repo;

    @Override
    public Portfolio create(Portfolio portfolio) {
        return repo.save(portfolio);
    }

    @Override
    public List<Portfolio> getAll() {
        return repo.findAll();
    }

    @Override
    public Portfolio getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));
    }

    @Override
    public Portfolio update(Long id, Portfolio portfolio) {
        Portfolio existing = getById(id);
        existing.setProjectName(portfolio.getProjectName());
        existing.setClientName(portfolio.getClientName());
        existing.setDescription(portfolio.getDescription());
        existing.setImage(portfolio.getImage());
        existing.setTechStack(portfolio.getTechStack());
        existing.setProjectUrl(portfolio.getProjectUrl());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
