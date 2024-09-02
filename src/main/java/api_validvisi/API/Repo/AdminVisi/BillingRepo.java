package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillingRepo extends JpaRepository<Billing, String> {
    Optional<Billing> findBillingById(String id);
}
