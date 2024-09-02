package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Career;
import api_validvisi.API.Repo.AdminVisi.CareerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CareerController {
    @Autowired
    private CareerRepo careerRepo;

    @GetMapping("/admin-visi/careers")
    public Map<String, Object> getCareers() {
        List<Career> careerList = careerRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", careerList);
        return response;
    }

    @GetMapping("/admin-visi/careers/{id}")
    public Map<String, Object> getCareerById(@PathVariable String id) {
        Career career = careerRepo.findCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", career);
        return response;
    }

    @PostMapping("/admin-visi/careers")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveCareer(@RequestBody Career career) {
        careerRepo.save(career);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Career successfully added");
        return response;
    }

    @PutMapping("/admin-visi/careers/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateCareer(@PathVariable String id, @RequestBody Career career) {
        Career updatedCareer = careerRepo.findCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career not found with id " + id));
        updatedCareer.setDepartment_id(career.getDepartment_id());
        updatedCareer.setCareer_type_id(career.getCareer_type_id());
        updatedCareer.setName(career.getName());
        updatedCareer.setDesc(career.getDesc());
        updatedCareer.setRequirements(career.getRequirements());
        updatedCareer.setExperience(career.getExperience());
        updatedCareer.setMeta_keywords(career.getMeta_keywords());
        updatedCareer.setCreated_by(career.getCreated_by());
        updatedCareer.setUpdated_by(career.getUpdated_by());
        updatedCareer.setCreated_at(LocalDateTime.now());
        updatedCareer.setUpdated_at(LocalDateTime.now());
        updatedCareer.setStatus(career.getStatus());
        careerRepo.save(updatedCareer);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Career successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/careers/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteCareer(@PathVariable String id) {
        Career deleteCareer = careerRepo.findCareerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career not found with id " + id));
        careerRepo.delete(deleteCareer);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Career successfully deleted");
        return response;
    }
}
