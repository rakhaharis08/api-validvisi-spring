package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepo extends JpaRepository<Subscriber, String> {
    Optional<Subscriber> findSubscriberById(String id);
}
