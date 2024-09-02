package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvertisementRepo extends JpaRepository<Advertisement, String> {
    Optional<Advertisement> findAdvertisementById(String id);
}
