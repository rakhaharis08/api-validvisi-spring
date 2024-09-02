package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Advertisement;
import api_validvisi.API.Repo.AdminVisi.AdvertisementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AdvertisementController {

    @Autowired
    private AdvertisementRepo advertisementRepo;

    @GetMapping("/admin-visi/advertisements")
    public Map<String, Object> getAdvertisements() {
        List<Advertisement> advertisements = advertisementRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", advertisements);
        return response;
    }

    @GetMapping("/admin-visi/advertisements/{id}")
    public Map<String, Object> getAdvertisementById(@PathVariable String id) {
        Optional<Advertisement> advertisement = advertisementRepo.findAdvertisementById(id);
        Map<String, Object> response = new HashMap<>();
        if (advertisement.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", advertisement.get());
        } else {
            response.put("success", false);
            response.put("message", "Advertisement not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("/admin-visi/advertisements")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveAdvertisement(@RequestBody Advertisement advertisement) {
        advertisementRepo.save(advertisement);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Advertisement Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("/admin-visi/advertisements/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateAdvertisement(@PathVariable String id, @RequestBody Advertisement advertisement) {
        Optional<Advertisement> existingAdvertisement = advertisementRepo.findAdvertisementById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingAdvertisement.isPresent()) {
            Advertisement updatedAdvertisement = existingAdvertisement.get();
            updatedAdvertisement.setPosition_id(advertisement.getPosition_id());
            updatedAdvertisement.setBanner_type_id(advertisement.getBanner_type_id());
            updatedAdvertisement.setDevice_id(advertisement.getDevice_id());
            updatedAdvertisement.setSequence(advertisement.getSequence());
            updatedAdvertisement.setTitle(advertisement.getTitle());
            updatedAdvertisement.setDesc(advertisement.getDesc());
            updatedAdvertisement.setThumbnail(advertisement.getThumbnail());
            updatedAdvertisement.setSource(advertisement.getSource());
            updatedAdvertisement.setCreated_by(advertisement.getCreated_by());
            updatedAdvertisement.setUpdated_by(advertisement.getUpdated_by());
            updatedAdvertisement.setCreated_at(LocalDateTime.now());
            updatedAdvertisement.setUpdated_at(LocalDateTime.now());
            updatedAdvertisement.setStatus(advertisement.getStatus());
            advertisementRepo.save(updatedAdvertisement);
            response.put("success", true);
            response.put("message", "Advertisement Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Advertisement not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/admin-visi/advertisements/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteAdvertisement(@PathVariable String id) {
        Optional<Advertisement> advertisement = advertisementRepo.findAdvertisementById(id);
        Map<String, Object> response = new HashMap<>();
        if (advertisement.isPresent()) {
            advertisementRepo.delete(advertisement.get());
            response.put("success", true);
            response.put("message", "Advertisement Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Advertisement not found with id " + id);
            response.put("data", null);
        }
        return response;
    }
}
