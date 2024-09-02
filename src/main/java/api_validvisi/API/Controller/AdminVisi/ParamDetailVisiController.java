package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Model.AdminVisi.ParamDetailVisi;
import api_validvisi.API.Repo.AdminVisi.ParamDetailVisiRepo;
import api_validvisi.API.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin-visi/param-details")
public class ParamDetailVisiController {

    @Autowired
    private ParamDetailVisiRepo ParamDetailVisiRepo;

    // Get all ParamDetailVisis
    @GetMapping
    public Map<String, Object> getAllParamDetailVisis() {
        List<ParamDetailVisi> ParamDetailVisis = ParamDetailVisiRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", ParamDetailVisis);
        return response;
    }

    // Get ParamDetailVisi by ID
    @GetMapping("/{id}")
    public Map<String, Object> getParamDetailVisiById(@PathVariable String id) {
        ParamDetailVisi ParamDetailVisi = ParamDetailVisiRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ParamDetailVisi not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", ParamDetailVisi);
        return response;
    }

    // Create new ParamDetailVisi
    @PostMapping
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> createParamDetailVisi(@RequestBody ParamDetailVisi ParamDetailVisi) {
        ParamDetailVisi.setCreated_at(LocalDateTime.now());
        ParamDetailVisi.setUpdated_at(LocalDateTime.now());
        ParamDetailVisiRepo.save(ParamDetailVisi);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ParamDetailVisi Berhasil Ditambahkan");
        response.put("data", ParamDetailVisi);
        return response;
    }

    // Update ParamDetailVisi by ID
    @PutMapping("/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateParamDetailVisi(@PathVariable String id, @RequestBody ParamDetailVisi ParamDetailVisiDetails) {
        ParamDetailVisi ParamDetailVisi = ParamDetailVisiRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ParamDetailVisi not found with id " + id));

        ParamDetailVisi.setParamId(ParamDetailVisiDetails.getParamId());
        ParamDetailVisi.setName(ParamDetailVisiDetails.getName());
        ParamDetailVisi.setDesc(ParamDetailVisiDetails.getDesc());
        ParamDetailVisi.setParent(ParamDetailVisiDetails.getParent());
        ParamDetailVisi.setLevel(ParamDetailVisiDetails.getLevel());
        ParamDetailVisi.setValue_1(ParamDetailVisiDetails.getValue_1());
        ParamDetailVisi.setValue_2(ParamDetailVisiDetails.getValue_2());
        ParamDetailVisi.setValue_3(ParamDetailVisiDetails.getValue_3());
        ParamDetailVisi.setCreated_by(ParamDetailVisiDetails.getCreated_by());
        ParamDetailVisi.setUpdated_by(ParamDetailVisiDetails.getUpdated_by());
        ParamDetailVisi.setStatus(ParamDetailVisiDetails.getStatus());
        ParamDetailVisi.setUpdated_at(LocalDateTime.now());

        ParamDetailVisiRepo.save(ParamDetailVisi);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ParamDetailVisi Berhasil Diupdate");
        response.put("data", ParamDetailVisi);
        return response;
    }

    // Delete ParamDetailVisi by ID
    @DeleteMapping("/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteParamDetailVisi(@PathVariable String id) {
        ParamDetailVisi ParamDetailVisi = ParamDetailVisiRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ParamDetailVisi not found with id " + id));
        ParamDetailVisiRepo.delete(ParamDetailVisi);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ParamDetailVisi Berhasil Dihapus");
        return response;
    }
}
