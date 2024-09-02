package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Admin;
import api_validvisi.API.Repo.AdminVisi.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    @GetMapping("/admin-visi/admins")
    public Map<String, Object> getAdmins() {
        List<Admin> admins = adminRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", admins);
        return response;
    }

    @GetMapping("/admin-visi/admins/{id}")
    public Map<String, Object> getAdminById(@PathVariable String id) {
        Optional<Admin> admin = adminRepo.findAdminById(id);
        Map<String, Object> response = new HashMap<>();
        if (admin.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", admin.get());
        } else {
            response.put("success", false);
            response.put("message", "Admin not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("/admin-visi/admins")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveAdmin(@RequestBody Admin admin) {
        adminRepo.save(admin);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Admin Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("/admin-visi/admins/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        Optional<Admin> existingAdmin = adminRepo.findAdminById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingAdmin.isPresent()) {
            Admin updatedAdmin = existingAdmin.get();
            updatedAdmin.setDepartment_id(admin.getDepartment_id());
            updatedAdmin.setFullname(admin.getFullname());
            updatedAdmin.setEmail(admin.getEmail());
            updatedAdmin.setEmail_token(admin.getEmail_token());
            updatedAdmin.setEmail_verified_at(admin.getEmail_verified_at());
            updatedAdmin.setPassword(admin.getPassword());
            updatedAdmin.setRemember_token(admin.getRemember_token());
            updatedAdmin.setNo_hp(admin.getNo_hp());
            updatedAdmin.setGender(admin.getGender());
            updatedAdmin.setDob(admin.getDob());
            updatedAdmin.setPob(admin.getPob());
            updatedAdmin.setCountry(admin.getCountry());
            updatedAdmin.setProvince(admin.getProvince());
            updatedAdmin.setCity(admin.getCity());
            updatedAdmin.setAddress(admin.getAddress());
            updatedAdmin.setZip_code(admin.getZip_code());
            updatedAdmin.setPhoto(admin.getPhoto());
            updatedAdmin.setShow_in_portal(admin.getShow_in_portal());
            updatedAdmin.setCreated_by(admin.getCreated_by());
            updatedAdmin.setUpdated_by(admin.getUpdated_by());
            updatedAdmin.setDeleted_at(admin.getDeleted_at());
            updatedAdmin.setCreated_at(LocalDateTime.now());
            updatedAdmin.setUpdated_at(LocalDateTime.now());
            updatedAdmin.setStatus(admin.getStatus());
            adminRepo.save(updatedAdmin);
            response.put("success", true);
            response.put("message", "Admin Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Admin not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/admin-visi/admins/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteAdmin(@PathVariable String id) {
        Optional<Admin> admin = adminRepo.findAdminById(id);
        Map<String, Object> response = new HashMap<>();
        if (admin.isPresent()) {
            adminRepo.delete(admin.get());
            response.put("success", true);
            response.put("message", "Admin Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Admin not found with id " + id);
            response.put("data", null);
        }
        return response;
    }
}
