package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.FormSections;
import api_validvisi.API.Repo.AdminVisi.FormSectionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormSectionsController {
    @Autowired
    private FormSectionsRepo formSectionsRepo;

    @GetMapping("/admin-visi/form-sections")
    public Map<String, Object> getFormSections() {
        List<FormSections> formSectionsList = formSectionsRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formSectionsList);
        return response;
    }

    @GetMapping("/admin-visi/form-sections/{id}")
    public Map<String, Object> getFormSectionById(@PathVariable String id) {
        FormSections formSection = formSectionsRepo.findFormSectionsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormSection not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formSection);
        return response;
    }

    @PostMapping("/admin-visi/form-sections")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveFormSection(@RequestBody FormSections formSection) {
        formSectionsRepo.save(formSection);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormSection Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/form-sections/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateFormSection(@PathVariable String id, @RequestBody FormSections formSection) {
        FormSections updatedFormSection = formSectionsRepo.findFormSectionsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormSection not found with id " + id));
        updatedFormSection.setForm_id(formSection.getForm_id());
        updatedFormSection.setTemplate(formSection.getTemplate());
        updatedFormSection.setAttribute(formSection.getAttribute());
        updatedFormSection.setQuestion(formSection.getQuestion());
        updatedFormSection.setDescription(formSection.getDescription());
        updatedFormSection.setRequired(formSection.isRequired());
        updatedFormSection.setOptions(formSection.getOptions());
        updatedFormSection.setFilled(formSection.getFilled());
        updatedFormSection.setNext(formSection.getNext());
        updatedFormSection.setDeleted_at(formSection.getDeleted_at());
        updatedFormSection.setCreated_at(LocalDateTime.now());
        updatedFormSection.setUpdated_at(LocalDateTime.now());
        formSectionsRepo.save(updatedFormSection);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormSection Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/form-sections/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteFormSection(@PathVariable String id) {
        FormSections deleteFormSection = formSectionsRepo.findFormSectionsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormSection not found with id " + id));
        formSectionsRepo.delete(deleteFormSection);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormSection Berhasil Dihapus");
        return response;
    }
}
