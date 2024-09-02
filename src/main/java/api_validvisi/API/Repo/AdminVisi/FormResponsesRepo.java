package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.FormResponses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormResponsesRepo extends JpaRepository<FormResponses, String> {
    Optional<FormResponses> findFormResponsesById(String id);
}
