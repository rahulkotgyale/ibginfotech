package ibginfotech.service;

import java.util.List;
import ibginfotech.entity.Faq;

public interface FaqService {
    Faq create(Faq faq);
    List<Faq> getAll();
    Faq getById(Long id);
    Faq update(Long id, Faq faq);
    void delete(Long id);
}
