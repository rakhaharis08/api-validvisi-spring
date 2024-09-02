package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepo extends JpaRepository<Voucher, String> {
    Optional<Voucher> findVoucherById(String id);
}
