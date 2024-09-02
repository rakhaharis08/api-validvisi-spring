package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CareerRepo extends JpaRepository<Career, String> {
    Optional<Career> findCareerById(String id);
}
