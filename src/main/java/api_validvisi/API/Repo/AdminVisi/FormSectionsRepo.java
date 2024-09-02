package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.FormSections;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormSectionsRepo extends JpaRepository<FormSections, String> {
    Optional<FormSections> findFormSectionsById(String id);
}
