package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Broadcast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BroadcastRepo extends JpaRepository<Broadcast, String> {
    Optional<Broadcast> findBroadcastById(String id);
}
