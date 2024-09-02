package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCommentRepo extends JpaRepository<UserComment, String> {
    Optional<UserComment> findUserCommentById(String id);
}
