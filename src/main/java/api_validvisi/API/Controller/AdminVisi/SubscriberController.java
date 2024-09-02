package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Subscriber;
import api_validvisi.API.Repo.AdminVisi.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SubscriberController {
    @Autowired
    private SubscriberRepo subscriberRepo;

    @GetMapping("/admin-visi/subscribers")
    public Map<String, Object> getSubscribers() {
        List<Subscriber> subscribersList = subscriberRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", subscribersList);
        return response;
    }

    @GetMapping("/admin-visi/subscribers/{id}")
    public Map<String, Object> getSubscriberById(@PathVariable String id) {
        Subscriber subscriber = subscriberRepo.findSubscriberById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", subscriber);
        return response;
    }

    @PostMapping("/admin-visi/subscribers")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveSubscriber(@RequestBody Subscriber subscriber) {
        subscriberRepo.save(subscriber);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Subscriber Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/subscribers/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateSubscriber(@PathVariable String id, @RequestBody Subscriber subscriber) {
        Subscriber updatedSubscriber = subscriberRepo.findSubscriberById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber found with id " + id));
        updatedSubscriber.setEmail(subscriber.getEmail());
        updatedSubscriber.setDesc(subscriber.getDesc());
        updatedSubscriber.setStatus(subscriber.getStatus());
        updatedSubscriber.setCreated_by(subscriber.getCreated_by());
        updatedSubscriber.setUpdated_by(subscriber.getUpdated_by());
        updatedSubscriber.setCreated_at(LocalDateTime.now());
        updatedSubscriber.setUpdated_at(LocalDateTime.now());
        subscriberRepo.save(updatedSubscriber);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Subscriber Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/subscribers/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteSubscriber(@PathVariable String id) {
        Subscriber deleteSubscriber = subscriberRepo.findSubscriberById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found with id " + id));
        subscriberRepo.delete(deleteSubscriber);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Subscriber Berhasil Dihapus");
        return response;
    }
}
