package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Partnership;
import api_validvisi.API.Repo.AdminVisi.PartnershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PartnershipController {
    @Autowired
    private PartnershipRepo partnershipRepo;

    @GetMapping("/admin-visi/partnerships")
    public Map<String, Object> getPartnerships() {
        List<Partnership> partnershipList = partnershipRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", partnershipList);
        return response;
    }

    @GetMapping("/admin-visi/partnerships/{id}")
    public Map<String, Object> getPartnershipById(@PathVariable String id) {
        Partnership partnership = partnershipRepo.findPartnershipById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partnership not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", partnership);
        return response;
    }

    @PostMapping("/admin-visi/partnerships")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> savePartnership(@RequestBody Partnership partnership) {
        partnershipRepo.save(partnership);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Partnership successfully added");
        return response;
    }

    @PutMapping("/admin-visi/partnerships/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updatePartnership(@PathVariable String id, @RequestBody Partnership partnership) {
        Partnership updatedPartnership = partnershipRepo.findPartnershipById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partnership not found with id " + id));
        updatedPartnership.setFullname(partnership.getFullname());
        updatedPartnership.setCompanyName(partnership.getCompanyName());
        updatedPartnership.setCompanyEmail(partnership.getCompanyEmail());
        updatedPartnership.setNoHp(partnership.getNoHp());
        updatedPartnership.setWebsite(partnership.getWebsite());
        updatedPartnership.setAddress(partnership.getAddress());
        updatedPartnership.setContent(partnership.getContent());
        updatedPartnership.setStatus(partnership.getStatus());
        updatedPartnership.setPhoto(partnership.getPhoto());
        updatedPartnership.setShowInPortal(partnership.getShowInPortal());
        updatedPartnership.setCreatedBy(partnership.getCreatedBy());
        updatedPartnership.setUpdatedBy(partnership.getUpdatedBy());
        updatedPartnership.setCreatedAt(LocalDateTime.now());
        updatedPartnership.setUpdatedAt(LocalDateTime.now());
        partnershipRepo.save(updatedPartnership);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Partnership successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/partnerships/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deletePartnership(@PathVariable String id) {
        Partnership deletePartnership = partnershipRepo.findPartnershipById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partnership not found with id " + id));
        partnershipRepo.delete(deletePartnership);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Partnership successfully deleted");
        return response;
    }
}
