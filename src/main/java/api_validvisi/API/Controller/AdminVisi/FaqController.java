package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Faq;
import api_validvisi.API.Repo.AdminVisi.FAQRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FaqController {
    @Autowired
    private FAQRepo FAQRepo;

    @GetMapping("/admin-visi/Faqs")
    public Map<String, Object> getFaqs() {
        List<Faq> FaqList = FAQRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", FaqList);
        return response;
    }

    @GetMapping("/admin-visi/Faqs/{id}")
    public Map<String, Object> getFaqById(@PathVariable String id) {
        Faq Faq = FAQRepo.findFAQById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faq not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", Faq);
        return response;
    }

    @PostMapping("/admin-visi/Faqs")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveFaq(@RequestBody Faq Faq) {
        FAQRepo.save(Faq);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Faq successfully added");
        return response;
    }

    @PutMapping("/admin-visi/Faqs/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateFaq(@PathVariable String id, @RequestBody Faq Faq) {
        Faq updatedFaq = FAQRepo.findFAQById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faq not found with id " + id));
        updatedFaq.setPageId(Faq.getPageId());
        updatedFaq.setLanguageId(Faq.getLanguageId());
        updatedFaq.setQuestion(Faq.getQuestion());
        updatedFaq.setAnswer(Faq.getAnswer());
        updatedFaq.setStatus(Faq.getStatus());
        updatedFaq.setCreatedBy(Faq.getCreatedBy());
        updatedFaq.setUpdatedBy(Faq.getUpdatedBy());
        updatedFaq.setCreatedAt(LocalDateTime.now());
        updatedFaq.setUpdatedAt(LocalDateTime.now());
        FAQRepo.save(updatedFaq);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Faq successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/Faqs/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteFaq(@PathVariable String id) {
        Faq deleteFaq = FAQRepo.findFAQById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faq not found with id " + id));
        FAQRepo.delete(deleteFaq);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Faq successfully deleted");
        return response;
    }
}
