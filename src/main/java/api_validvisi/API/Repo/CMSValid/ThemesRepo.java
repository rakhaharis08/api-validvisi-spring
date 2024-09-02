package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.Themes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemesRepo extends JpaRepository<Themes, Long> {
    Optional<Themes> findThemesById(int id);
}
