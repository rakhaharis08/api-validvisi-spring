package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepo extends JpaRepository<Tag, String> {
    Optional<Tag> findTagById(String id);
}
