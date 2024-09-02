package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(int id);
}
