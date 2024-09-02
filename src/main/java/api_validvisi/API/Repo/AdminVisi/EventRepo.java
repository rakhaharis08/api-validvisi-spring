package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, String> {
    Optional<Event> findEventById(String id);
}
