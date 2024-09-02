package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Product;
import api_validvisi.API.Model.AdminVisi.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, String> {
    Optional<Product> getProductById(String id);
    @Query("SELECT COUNT(vr) FROM Product vr")
    Long countTotalProduct();

}
