package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Sender;
import api_validvisi.API.Repo.AdminVisi.SenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SenderController {
    @Autowired
    private SenderRepo senderRepo;

    @GetMapping("/admin-visi/senders")
    public Map<String, Object> getSenders() {
        List<Sender> senderList = senderRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", senderList);
        return response;
    }

    @GetMapping("/admin-visi/senders/{id}")
    public Map<String, Object> getSenderById(@PathVariable String id) {
        Sender sender = senderRepo.findSenderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", sender);
        return response;
    }

    @PostMapping("/admin-visi/senders")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveSender(@RequestBody Sender sender) {
        senderRepo.save(sender);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Sender successfully added");
        return response;
    }

    @PutMapping("/admin-visi/senders/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateSender(@PathVariable String id, @RequestBody Sender sender) {
        Sender updatedSender = senderRepo.findSenderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with id " + id));
        updatedSender.setType(sender.getType());
        updatedSender.setName(sender.getName());
        updatedSender.setDescription(sender.getDescription());
        updatedSender.setPhone(sender.getPhone());
        updatedSender.setStatus(sender.getStatus());
        updatedSender.setCreatedBy(sender.getCreatedBy());
        updatedSender.setUpdatedBy(sender.getUpdatedBy());
        updatedSender.setCreatedAt(LocalDateTime.now());
        updatedSender.setUpdatedAt(LocalDateTime.now());
        senderRepo.save(updatedSender);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Sender successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/senders/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteSender(@PathVariable String id) {
        Sender deleteSender = senderRepo.findSenderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found with id " + id));
        senderRepo.delete(deleteSender);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Sender successfully deleted");
        return response;
    }
}
