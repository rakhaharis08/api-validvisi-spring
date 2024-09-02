package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.BillingDetail;
import api_validvisi.API.Model.AdminVisi.MediaMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MediaMonitorRepo extends JpaRepository<MediaMonitor, String> {
    Optional<MediaMonitor> findMediaMonitorById(String id);
    long countByMediaType(String mediaType);
}
