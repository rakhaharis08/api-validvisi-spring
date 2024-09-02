package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findUsersById(int id);
}
