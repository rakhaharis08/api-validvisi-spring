package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.UserCareer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCareerRepo extends JpaRepository<UserCareer, String> {
    Optional<UserCareer> findUserCareerById(String id);
}
