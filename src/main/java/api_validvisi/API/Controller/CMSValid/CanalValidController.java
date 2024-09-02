package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.CanalValid;
import api_validvisi.API.Repo.CMSValid.CanalValidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CanalValidController {
    @Autowired
    private CanalValidRepo canalValidRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "canal_topic";

    @GetMapping("cms-valid/canal")
    public Map<String, Object> getCanal() {
        List<CanalValid> canals = canalValidRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", canals);
        return response;
    }

    @GetMapping("cms-valid/canal/{id}")
    public Map<String, Object> getCanalById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<CanalValid> canalValid = canalValidRepo.findCanalById(id);

        if (canalValid.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", canalValid.get());
        } else {
            response.put("success", false);
            response.put("message", "Canal tidak ditemukan dengan id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping("cms-valid/canal")
    public Map<String, Object> saveCanal(@RequestBody CanalValid canalValid) {
        canalValidRepo.save(canalValid);
        kafkaTemplate.send(TOPIC, "Canal added: " + canalValid.toString());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Canal Berhasil Ditambahkan");
        response.put("data", null);

        return response;
    }

    @PutMapping("cms-valid/canal/update/{id}")
    public Map<String, Object> updateCanal(@PathVariable int id, @RequestBody CanalValid canalValid) {
        Map<String, Object> response = new HashMap<>();
        Optional<CanalValid> existingCanal = canalValidRepo.findCanalById(id);

        if (existingCanal.isPresent()) {
            CanalValid updatedCanalValid = existingCanal.get();
            updatedCanalValid.setName(canalValid.getName());
            updatedCanalValid.setSlug(canalValid.getSlug());
            updatedCanalValid.setParam_id(canalValid.getParam_id());
            updatedCanalValid.setType(canalValid.getType());
            updatedCanalValid.setStatus(canalValid.getStatus());
            updatedCanalValid.setEmployee_id(canalValid.getEmployee_id());
            canalValidRepo.save(updatedCanalValid);
            kafkaTemplate.send(TOPIC, "Canal updated: " + updatedCanalValid.toString());

            response.put("success", true);
            response.put("message", "Parameter Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Canal tidak ditemukan dengan id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping("cms-valid/canal/delete/{id}")
    public Map<String, Object> deleteCanal(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<CanalValid> deleteCanalValid = canalValidRepo.findCanalById(id);

        if (deleteCanalValid.isPresent()) {
            canalValidRepo.delete(deleteCanalValid.get());
            kafkaTemplate.send(TOPIC, "Canal deleted: " + deleteCanalValid.toString());

            response.put("success", true);
            response.put("message", "Parameter Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Canal tidak ditemukan dengan id " + id);
            response.put("data", null);
        }

        return response;
    }
}
