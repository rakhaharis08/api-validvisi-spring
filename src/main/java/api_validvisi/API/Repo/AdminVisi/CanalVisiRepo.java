package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Billing;
import api_validvisi.API.Model.AdminVisi.CanalVisi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CanalVisiRepo extends JpaRepository<CanalVisi, String> {
    Optional<CanalVisi> findCanalVisiById(String id);
}
