package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Event;
import api_validvisi.API.Repo.CMSValid.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "cms-valid/event")
    public Map<String, Object> getEvent() {
        List<Event> events = eventRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", events);
        return response;
    }

    @GetMapping(value = "cms-valid/event/{id}")
    public Map<String, Object> getEventById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Event> event = eventRepo.findEventById(id);

        if (event.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", event.get());
        } else {
            response.put("success", false);
            response.put("message", "Event not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/event")
    public Map<String, Object> saveEvent(@RequestBody Event event) {
        eventRepo.save(event);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Event Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value = "cms-valid/event/update/{id}")
    public Map<String, Object> updateEvent(@PathVariable int id, @RequestBody Event event) {
        Map<String, Object> response = new HashMap<>();
        Optional<Event> existingEvent = eventRepo.findEventById(id);

        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setTitle(event.getTitle());
            updatedEvent.setDescription(event.getDescription());
            updatedEvent.setDevice_type(event.getDevice_type());
            updatedEvent.setImage(event.getImage());
            updatedEvent.setDate(event.getDate());
            updatedEvent.setUpdated_at(LocalDateTime.now());
            updatedEvent.setSeo(event.getSeo());
            updatedEvent.setSlug(event.getSlug());
            updatedEvent.setEmployee_id(event.getEmployee_id());
            updatedEvent.setStart_date(event.getStart_date());
            updatedEvent.setEnd_date(event.getEnd_date());
            updatedEvent.setStatus(event.getStatus());
            updatedEvent.setUrl(event.getUrl());
            eventRepo.save(updatedEvent);

            response.put("success", true);
            response.put("message", "Event Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Event not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/event/delete/{id}")
    public Map<String, Object> deleteEvent(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Event> deleteEvent = eventRepo.findEventById(id);

        if (deleteEvent.isPresent()) {
            eventRepo.delete(deleteEvent.get());
            response.put("success", true);
            response.put("message", "Event Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Event not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
