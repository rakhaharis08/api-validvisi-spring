package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, String> {
    Optional<Client> findClientById(String id);
}
