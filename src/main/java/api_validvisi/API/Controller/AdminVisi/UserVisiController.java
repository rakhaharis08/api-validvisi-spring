package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.User;
import api_validvisi.API.Repo.AdminVisi.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserVisiController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/admin-visi/users")
    public Map<String, Object> getUser() {
        List<User> usersList = userRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", usersList);
        return response;
    }

    @GetMapping("/admin-visi/users/{id}")
    public Map<String, Object> getUserById(@PathVariable String id) {
        User user = userRepo.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", user);
        return response;
    }

    @PostMapping("/admin-visi/users")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveUser(@RequestBody User user) {
        userRepo.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/users/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userRepo.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User found with id " + id));
        updatedUser.setFirst_name(user.getFirst_name());
        updatedUser.setLast_name(user.getLast_name());
        updatedUser.setFullname(user.getFullname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setEmail_token(user.getEmail_token());
        updatedUser.setEmail_verified_at(user.getEmail_verified_at());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRemember_token(user.getRemember_token());
        updatedUser.setNo_hp(user.getNo_hp());
        updatedUser.setFcm_token(user.getFcm_token());
        updatedUser.setSubscribe(user.getSubscribe());
        updatedUser.setGender(user.getGender());
        updatedUser.setDob(user.getDob());
        updatedUser.setPob(user.getPob());
        updatedUser.setCountry(user.getCountry());
        updatedUser.setProvince(user.getProvince());
        updatedUser.setCity(user.getCity());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setZip_code(user.getZip_code());
        updatedUser.setPhoto(user.getPhoto());
        updatedUser.setCreated_by(user.getCreated_by());
        updatedUser.setUpdated_by(user.getUpdated_by());
        updatedUser.setDeleted_at(user.getDeleted_at());
        updatedUser.setCreated_at(LocalDateTime.now());
        updatedUser.setUpdated_at(LocalDateTime.now());
        updatedUser.setStatus(user.getStatus());
        userRepo.save(updatedUser);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/users/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteUser(@PathVariable String id) {
        User deleteUser = userRepo.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepo.delete(deleteUser);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User Berhasil Dihapus");
        return response;
    }
}
