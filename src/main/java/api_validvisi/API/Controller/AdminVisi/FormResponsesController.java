package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.FormResponses;
import api_validvisi.API.Repo.AdminVisi.FormResponsesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormResponsesController {
    @Autowired
    private FormResponsesRepo formResponsesRepo;

    @GetMapping("/admin-visi/form-responses")
    public Map<String, Object> getFormResponses() {
        List<FormResponses> formResponsesList = formResponsesRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formResponsesList);
        return response;
    }

    @GetMapping("/admin-visi/form-responses/{id}")
    public Map<String, Object> getFormResponseById(@PathVariable String id) {
        FormResponses formResponse = formResponsesRepo.findFormResponsesById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormResponse not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formResponse);
        return response;
    }

    @PostMapping("/admin-visi/form-responses")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveFormResponse(@RequestBody FormResponses formResponse) {
        formResponsesRepo.save(formResponse);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormResponse Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/form-responses/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateFormResponse(@PathVariable String id, @RequestBody FormResponses formResponse) {
        FormResponses updatedFormResponse = formResponsesRepo.findFormResponsesById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormResponse not found with id " + id));
        updatedFormResponse.setResponden_id(formResponse.getResponden_id());
        updatedFormResponse.setForm_id(formResponse.getForm_id());
        updatedFormResponse.setForm_field_id(formResponse.getForm_field_id());
        updatedFormResponse.setResponse_code(formResponse.getResponse_code());
        updatedFormResponse.setRespondent_ip(formResponse.getRespondent_ip());
        updatedFormResponse.setRespondent_user_agent(formResponse.getRespondent_user_agent());
        updatedFormResponse.setLatitude(formResponse.getLatitude());
        updatedFormResponse.setLongitude(formResponse.getLongitude());
        updatedFormResponse.setDeleted_at(formResponse.getDeleted_at());
        updatedFormResponse.setCreated_at(LocalDateTime.now());
        updatedFormResponse.setUpdated_at(LocalDateTime.now());
        formResponsesRepo.save(updatedFormResponse);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormResponse Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/form-responses/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteFormResponse(@PathVariable String id) {
        FormResponses deleteFormResponse = formResponsesRepo.findFormResponsesById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormResponse not found with id " + id));
        formResponsesRepo.delete(deleteFormResponse);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormResponse Berhasil Dihapus");
        return response;
    }
}
