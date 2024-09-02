package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SenderRepo extends JpaRepository<Sender, String> {
    Optional<Sender> findSenderById(String id);
}
