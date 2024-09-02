package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepo extends JpaRepository<Page, String> {
    Optional<Page> findPageById(String id);
}
