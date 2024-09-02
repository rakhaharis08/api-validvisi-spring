package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.UserCareer;
import api_validvisi.API.Repo.AdminVisi.UserCareerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserCareerController {
    @Autowired
    private UserCareerRepo userCareerRepo;

    @GetMapping("/admin-visi/user-careers")
    public Map<String, Object> getUserCareers() {
        List<UserCareer> userCareerList = userCareerRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", userCareerList);
        return response;
    }

    @GetMapping("/admin-visi/user-careers/{id}")
    public Map<String, Object> getUserCareerById(@PathVariable String id) {
        UserCareer userCareer = userCareerRepo.findUserCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCareer not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", userCareer);
        return response;
    }

    @PostMapping("/admin-visi/user-careers")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveUserCareer(@RequestBody UserCareer userCareer) {
        userCareerRepo.save(userCareer);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserCareer successfully added");
        return response;
    }

    @PutMapping("/admin-visi/user-careers/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateUserCareer(@PathVariable String id, @RequestBody UserCareer userCareer) {
        UserCareer updatedUserCareer = userCareerRepo.findUserCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCareer not found with id " + id));
        updatedUserCareer.setFullname(userCareer.getFullname());
        updatedUserCareer.setEmail(userCareer.getEmail());
        updatedUserCareer.setNo_hp(userCareer.getNo_hp());
        updatedUserCareer.setPortfolio(userCareer.getPortfolio());
        updatedUserCareer.setUrl_portfolio(userCareer.getUrl_portfolio());
        updatedUserCareer.setResume(userCareer.getResume());
        updatedUserCareer.setCreated_by(userCareer.getCreated_by());
        updatedUserCareer.setUpdated_by(userCareer.getUpdated_by());
        updatedUserCareer.setCreated_at(LocalDateTime.now());
        updatedUserCareer.setUpdated_at(LocalDateTime.now());
        updatedUserCareer.setStatus(userCareer.getStatus());
        userCareerRepo.save(updatedUserCareer);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserCareer successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/user-careers/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteUserCareer(@PathVariable String id) {
        UserCareer deleteUserCareer = userCareerRepo.findUserCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserCareer not found with id " + id));
        userCareerRepo.delete(deleteUserCareer);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserCareer successfully deleted");
        return response;
    }
}
