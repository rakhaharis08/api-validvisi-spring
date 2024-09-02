package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Forms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormsRepo extends JpaRepository<Forms, String> {
    Optional<Forms> findFormsById(String id);
}
