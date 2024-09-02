package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.CanalVisi;
import api_validvisi.API.Repo.AdminVisi.CanalVisiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CanalVisiController {

    @Autowired
    private CanalVisiRepo canalVisiRepo;

    @GetMapping("/admin-visi/canals")
    public Map<String, Object> getCanalVisi() {
        List<CanalVisi> canalVisiList = canalVisiRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", canalVisiList);
        return response;
    }

    @GetMapping("/admin-visi/canals/{id}")
    public Map<String, Object> getCanalVisiById(@PathVariable String id) {
        Optional<CanalVisi> canalVisi = canalVisiRepo.findCanalVisiById(id);
        Map<String, Object> response = new HashMap<>();
        if (canalVisi.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", canalVisi.get());
        } else {
            response.put("success", false);
            response.put("message", "Canal not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("/admin-visi/canals")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveCanalVisi(@RequestBody CanalVisi canalVisi) {
        canalVisiRepo.save(canalVisi);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Canal Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("/admin-visi/canals/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateCanalVisi(@PathVariable String id, @RequestBody CanalVisi canalVisi) {
        Optional<CanalVisi> existingCanalVisi = canalVisiRepo.findCanalVisiById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingCanalVisi.isPresent()) {
            CanalVisi updatedCanalVisi = existingCanalVisi.get();
            updatedCanalVisi.setName(canalVisi.getName());
            updatedCanalVisi.setDesc(canalVisi.getDesc());
            updatedCanalVisi.setParent(canalVisi.getParent());
            updatedCanalVisi.setLevel(canalVisi.getLevel());
            updatedCanalVisi.setSlug(canalVisi.getSlug());
            updatedCanalVisi.setMeta_title(canalVisi.getMeta_title());
            updatedCanalVisi.setMeta_description(canalVisi.getMeta_description());
            updatedCanalVisi.setMeta_keywords(canalVisi.getMeta_keywords());
            updatedCanalVisi.setCreated_by(canalVisi.getCreated_by());
            updatedCanalVisi.setUpdated_by(canalVisi.getUpdated_by());
            updatedCanalVisi.setUpdated_at(LocalDateTime.now());
            updatedCanalVisi.setStatus(canalVisi.getStatus());
            canalVisiRepo.save(updatedCanalVisi);
            response.put("success", true);
            response.put("message", "Canal Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Canal not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/admin-visi/canals/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteCanalVisi(@PathVariable String id) {
        Optional<CanalVisi> canalVisi = canalVisiRepo.findCanalVisiById(id);
        Map<String, Object> response = new HashMap<>();
        if (canalVisi.isPresent()) {
            canalVisiRepo.delete(canalVisi.get());
            response.put("success", true);
            response.put("message", "Canal Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Canal not found with id " + id);
            response.put("data", null);
        }
        return response;
    }
}
