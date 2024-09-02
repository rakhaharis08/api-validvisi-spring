package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemeRepo extends JpaRepository<Theme, String> {
    Optional<Theme> findThemeById(String id);
}
