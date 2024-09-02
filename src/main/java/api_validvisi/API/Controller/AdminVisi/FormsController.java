package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Forms;
import api_validvisi.API.Repo.AdminVisi.FormsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormsController {
    @Autowired
    private FormsRepo formsRepo;

    @GetMapping("/admin-visi/forms")
    public Map<String, Object> getForms() {
        List<Forms> formsList = formsRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formsList);
        return response;
    }

    @GetMapping("/admin-visi/forms/{id}")
    public Map<String, Object> getFormById(@PathVariable String id) {
        Forms form = formsRepo.findFormsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", form);
        return response;
    }

    @PostMapping("/admin-visi/forms")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveForm(@RequestBody Forms form) {
        formsRepo.save(form);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Form Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/forms/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateForm(@PathVariable String id, @RequestBody Forms form) {
        Forms updatedForm = formsRepo.findFormsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with id " + id));
        updatedForm.setUser_id(form.getUser_id());
        updatedForm.setTitle(form.getTitle());
        updatedForm.setDescription(form.getDescription());
        updatedForm.setCode(form.getCode());
        updatedForm.setImage(form.getImage());
        updatedForm.setStatus(form.getStatus());
        updatedForm.setDeleted_at(form.getDeleted_at());
        updatedForm.setCreated_at(LocalDateTime.now());
        updatedForm.setUpdated_at(LocalDateTime.now());
        formsRepo.save(updatedForm);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Form Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/forms/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteForm(@PathVariable String id) {
        Forms deleteForm = formsRepo.findFormsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form not found with id " + id));
        formsRepo.delete(deleteForm);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Form Berhasil Dihapus");
        return response;
    }
}
