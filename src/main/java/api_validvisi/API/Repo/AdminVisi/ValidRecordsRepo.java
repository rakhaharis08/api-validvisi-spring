package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.ValidRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ValidRecordsRepo extends JpaRepository<ValidRecord, String> {
    Optional<ValidRecord> getValidRecordsById(String id);
    @Query("SELECT COUNT(vr) FROM ValidRecord vr")
    Long countTotalValidRecords();

}
