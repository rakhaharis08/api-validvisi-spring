package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepo extends JpaRepository<Document, String> {
    Optional<Document> findDocumentById(String id);
}
