package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatisticsRepo extends JpaRepository<Statistics, String> {
    Optional<Statistics> findStatisticsById(String id);
    @Query("SELECT COUNT(vr) FROM Statistics vr")
    Long countTotalStatistic();

}
