package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.ContactUs;
import api_validvisi.API.Repo.AdminVisi.ContactUsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContactUsController {
    @Autowired
    private ContactUsRepo contactUsRepo;

    @GetMapping("/admin-visi/contact-us")
    public Map<String, Object> getContactUs() {
        List<ContactUs> contactUsList = contactUsRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", contactUsList);
        return response;
    }

    @GetMapping("/admin-visi/contact-us/{id}")
    public Map<String, Object> getContactUsById(@PathVariable String id) {
        ContactUs contactUs = contactUsRepo.findContactUsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", contactUs);
        return response;
    }

    @PostMapping("/admin-visi/contact-us")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveContactUs(@RequestBody ContactUs contactUs) {
        contactUsRepo.save(contactUs);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ContactUs successfully added");
        return response;
    }

    @PutMapping("/admin-visi/contact-us/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateContactUs(@PathVariable String id, @RequestBody ContactUs contactUs) {
        ContactUs updatedContactUs = contactUsRepo.findContactUsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs not found with id " + id));
        updatedContactUs.setName(contactUs.getName());
        updatedContactUs.setEmail(contactUs.getEmail());
        updatedContactUs.setPhone(contactUs.getPhone());
        updatedContactUs.setMessage(contactUs.getMessage());
        updatedContactUs.setStatus(contactUs.getStatus());
        updatedContactUs.setCreatedBy(contactUs.getCreatedBy());
        updatedContactUs.setUpdatedBy(contactUs.getUpdatedBy());
        updatedContactUs.setCreatedAt(LocalDateTime.now());
        updatedContactUs.setUpdatedAt(LocalDateTime.now());
        contactUsRepo.save(updatedContactUs);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ContactUs successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/contact-us/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteContactUs(@PathVariable String id) {
        ContactUs deleteContactUs = contactUsRepo.findContactUsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs not found with id " + id));
        contactUsRepo.delete(deleteContactUs);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ContactUs successfully deleted");
        return response;
    }
}
