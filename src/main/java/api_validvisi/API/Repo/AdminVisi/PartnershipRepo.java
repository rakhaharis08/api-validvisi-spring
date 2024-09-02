package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Partnership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnershipRepo extends JpaRepository<Partnership, String> {
    Optional<Partnership> findPartnershipById(String id);
}
