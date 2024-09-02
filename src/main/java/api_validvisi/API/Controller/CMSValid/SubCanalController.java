package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Kafka.KafkaProducerConfig;
import api_validvisi.API.Model.CMSValid.SubCanal;
import api_validvisi.API.Repo.CMSValid.SubCanalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SubCanalController {

    private final KafkaProducerConfig kafkaProducer;

    @Autowired
    private SubCanalRepo subCanalRepo;

    public SubCanalController(KafkaProducerConfig kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping(value="cms-valid/subcanal")
    public Map<String, Object> getSubCanal(){
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", subCanalRepo.findAll());
        return response;
    }

    @GetMapping(value="cms-valid/subcanal/{id}")
    public Map<String, Object> getSubCanalById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<SubCanal> subCanal = subCanalRepo.findSubCanalById(id);

        if (subCanal.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", subCanal.get());
        } else {
            response.put("success", false);
            response.put("message", "SubCanal not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/subcanal")
    public Map<String, Object> saveSubCanal(@RequestBody SubCanal subCanal){
        subCanalRepo.save(subCanal);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "SubCanal Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value= "cms-valid/subcanal/update/{id}")
    public Map<String, Object> updateSubCanal (@PathVariable int id, @RequestBody SubCanal subCanal){
        Map<String, Object> response = new HashMap<>();
        Optional<SubCanal> existingSubCanal = subCanalRepo.findSubCanalById(id);

        if (existingSubCanal.isPresent()) {
            SubCanal updatedSubCanal = existingSubCanal.get();
            updatedSubCanal.setName(subCanal.getName());
            updatedSubCanal.setCanal_id(subCanal.getCanal_id());
            updatedSubCanal.setParent(subCanal.getParent());
            updatedSubCanal.setSlug(subCanal.getSlug());
            updatedSubCanal.setEmployee_id(subCanal.getEmployee_id());
            updatedSubCanal.setStatus(subCanal.getStatus());
            updatedSubCanal.setUpdated_at(LocalDateTime.now());
            subCanalRepo.save(updatedSubCanal);

            response.put("success", true);
            response.put("message", "SubCanal Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "SubCanal not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/subcanal/delete/{id}")
    public Map<String, Object> deleteSubCanal(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<SubCanal> subCanal = subCanalRepo.findSubCanalById(id);

        if (subCanal.isPresent()) {
            subCanalRepo.delete(subCanal.get());
            response.put("success", true);
            response.put("message", "SubCanal Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "SubCanal not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
