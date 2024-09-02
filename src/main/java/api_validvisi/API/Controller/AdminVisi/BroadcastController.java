package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Broadcast;
import api_validvisi.API.Repo.AdminVisi.BroadcastRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BroadcastController {
    @Autowired
    private BroadcastRepo broadcastRepo;

    @GetMapping("/admin-visi/broadcasts")
    public Map<String, Object> getBroadcasts() {
        List<Broadcast> broadcastList = broadcastRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", broadcastList);
        return response;
    }

    @GetMapping("/admin-visi/broadcasts/{id}")
    public Map<String, Object> getBroadcastById(@PathVariable String id) {
        Broadcast broadcast = broadcastRepo.findBroadcastById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Broadcast not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", broadcast);
        return response;
    }

    @PostMapping("/admin-visi/broadcasts")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveBroadcast(@RequestBody Broadcast broadcast) {
        broadcastRepo.save(broadcast);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Broadcast successfully added");
        return response;
    }

    @PutMapping("/admin-visi/broadcasts/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateBroadcast(@PathVariable String id, @RequestBody Broadcast broadcast) {
        Broadcast updatedBroadcast = broadcastRepo.findBroadcastById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Broadcast not found with id " + id));
        updatedBroadcast.setChannelId(broadcast.getChannelId());
        updatedBroadcast.setPageId(broadcast.getPageId());
        updatedBroadcast.setSubPageId(broadcast.getSubPageId());
        updatedBroadcast.setTitle(broadcast.getTitle());
        updatedBroadcast.setDesc(broadcast.getDesc());
        updatedBroadcast.setCreatedBy(broadcast.getCreatedBy());
        updatedBroadcast.setUpdatedBy(broadcast.getUpdatedBy());
        updatedBroadcast.setCreatedAt(LocalDateTime.now());
        updatedBroadcast.setUpdatedAt(LocalDateTime.now());
        updatedBroadcast.setStatus(broadcast.getStatus());
        broadcastRepo.save(updatedBroadcast);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Broadcast successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/broadcasts/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteBroadcast(@PathVariable String id) {
        Broadcast deleteBroadcast = broadcastRepo.findBroadcastById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Broadcast not found with id " + id));
        broadcastRepo.delete(deleteBroadcast);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Broadcast successfully deleted");
        return response;
    }
}
