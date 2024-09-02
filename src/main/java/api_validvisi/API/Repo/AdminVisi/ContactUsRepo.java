package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactUsRepo extends JpaRepository<ContactUs, String> {
    Optional<ContactUs> findContactUsById(String id);
}
