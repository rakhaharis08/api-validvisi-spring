package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Event;
import api_validvisi.API.Repo.AdminVisi.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EventController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/admin-visi/events")
    public Map<String, Object> getEvents() {
        List<Event> eventList = eventRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", eventList);
        return response;
    }

    @GetMapping("/admin-visi/events/{id}")
    public Map<String, Object> getEventById(@PathVariable String id) {
        Event event = eventRepo.findEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", event);
        return response;
    }

    @PostMapping("/admin-visi/events")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveEvent(@RequestBody Event event) {
        eventRepo.save(event);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Event successfully added");
        return response;
    }

    @PutMapping("/admin-visi/events/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateEvent(@PathVariable String id, @RequestBody Event event) {
        Event updatedEvent = eventRepo.findEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
        updatedEvent.setCategoryEventId(event.getCategoryEventId());
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setSlug(event.getSlug());
        updatedEvent.setLowerTitle(event.getLowerTitle());
        updatedEvent.setDesc(event.getDesc());
        updatedEvent.setPlace(event.getPlace());
        updatedEvent.setSource(event.getSource());
        updatedEvent.setMetaKeywords(event.getMetaKeywords());
        updatedEvent.setPhoto(event.getPhoto());
        updatedEvent.setCreatedBy(event.getCreatedBy());
        updatedEvent.setUpdatedBy(event.getUpdatedBy());
        updatedEvent.setRegistrationDate(event.getRegistrationDate());
        updatedEvent.setCreatedAt(LocalDateTime.now());
        updatedEvent.setUpdatedAt(LocalDateTime.now());
        updatedEvent.setStatus(event.getStatus());
        eventRepo.save(updatedEvent);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Event successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/events/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteEvent(@PathVariable String id) {
        Event deleteEvent = eventRepo.findEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + id));
        eventRepo.delete(deleteEvent);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Event successfully deleted");
        return response;
    }
}
