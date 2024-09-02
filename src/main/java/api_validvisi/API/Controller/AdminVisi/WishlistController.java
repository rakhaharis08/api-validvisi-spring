package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Wishlist;
import api_validvisi.API.Repo.AdminVisi.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WishlistController {
    @Autowired
    private WishlistRepo wishlistRepo;

    @GetMapping("/admin-visi/wishlists")
    public Map<String, Object> getWishlists() {
        List<Wishlist> wishlistList = wishlistRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", wishlistList);
        return response;
    }

    @GetMapping("/admin-visi/wishlists/{id}")
    public Map<String, Object> getWishlistById(@PathVariable String id) {
        Wishlist wishlist = wishlistRepo.findWishlistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", wishlist);
        return response;
    }

    @PostMapping("/admin-visi/wishlists")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveWishlist(@RequestBody Wishlist wishlist) {
        wishlistRepo.save(wishlist);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Wishlist successfully added");
        return response;
    }

    @PutMapping("/admin-visi/wishlists/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateWishlist(@PathVariable String id, @RequestBody Wishlist wishlist) {
        Wishlist updatedWishlist = wishlistRepo.findWishlistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id " + id));
        updatedWishlist.setUser_id(wishlist.getUser_id());
        updatedWishlist.setProduct_id(wishlist.getProduct_id());
        updatedWishlist.setCreated_by(wishlist.getCreated_by());
        updatedWishlist.setUpdated_by(wishlist.getUpdated_by());
        updatedWishlist.setCreated_at(LocalDateTime.now());
        updatedWishlist.setUpdated_at(LocalDateTime.now());
        updatedWishlist.setStatus(wishlist.getStatus());
        wishlistRepo.save(updatedWishlist);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Wishlist successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/wishlists/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteWishlist(@PathVariable String id) {
        Wishlist deleteWishlist = wishlistRepo.findWishlistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist not found with id " + id));
        wishlistRepo.delete(deleteWishlist);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Wishlist successfully deleted");
        return response;
    }
}
