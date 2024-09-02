package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepo extends JpaRepository<Wishlist, String> {
    Optional<Wishlist> findWishlistById(String id);
}
