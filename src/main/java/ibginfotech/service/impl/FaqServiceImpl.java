package ibginfotech.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ibginfotech.entity.Faq;
import ibginfotech.repository.FaqRepository;
import ibginfotech.service.FaqService;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqRepository repo;

    @Override
    public Faq create(Faq faq) {
        return repo.save(faq);
    }

    @Override
    public List<Faq> getAll() {
        return repo.findAll();
    }

    @Override
    public Faq getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Faq not found with id " + id));
    }

    @Override
    public Faq update(Long id, Faq faq) {
        Faq existing = getById(id);
        existing.setQuestion(faq.getQuestion());
        existing.setAnswer(faq.getAnswer());
        existing.setActive(faq.isActive());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
