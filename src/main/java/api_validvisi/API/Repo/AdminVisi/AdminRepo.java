package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, String> {
    Optional<Admin> findAdminById(String id);
}
