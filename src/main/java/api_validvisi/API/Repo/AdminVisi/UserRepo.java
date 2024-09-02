package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);
}
