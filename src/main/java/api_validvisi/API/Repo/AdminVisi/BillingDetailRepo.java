package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.BillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BillingDetailRepo extends JpaRepository<BillingDetail, String> {
    Optional<BillingDetail> findBillingDetailById(String id);

    @Query("SELECT SUM(bd.trx_total) FROM BillingDetail bd WHERE bd.status = :status")
    Double getTotalTrxTotalByStatus(String status);

    @Query("SELECT EXTRACT(MONTH FROM b.created_at) AS month, SUM(b.trx_total) AS total " +
            "FROM BillingDetail b " +
            "WHERE b.status = :status AND EXTRACT(YEAR FROM b.created_at) = EXTRACT(YEAR FROM CURRENT_DATE) " +
            "GROUP BY EXTRACT(MONTH FROM b.created_at)")
    List<Object[]> findMonthlyTotalsByStatus(@Param("status") String status);
}
