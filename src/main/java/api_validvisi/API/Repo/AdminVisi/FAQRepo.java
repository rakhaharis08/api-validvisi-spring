package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FAQRepo extends JpaRepository<Faq, String> {
    Optional<Faq> findFAQById(String id);
}
