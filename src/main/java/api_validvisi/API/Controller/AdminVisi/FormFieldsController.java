package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.FormFields;
import api_validvisi.API.Repo.AdminVisi.FormFieldsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FormFieldsController {
    @Autowired
    private FormFieldsRepo formFieldsRepo;

    @GetMapping("/admin-visi/form-fields")
    public Map<String, Object> getFormFields() {
        List<FormFields> formFieldsList = formFieldsRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formFieldsList);
        return response;
    }

    @GetMapping("/admin-visi/form-fields/{id}")
    public Map<String, Object> getFormFieldById(@PathVariable String id) {
        FormFields formField = formFieldsRepo.findFormFieldsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormField not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formField);
        return response;
    }

    @PostMapping("/admin-visi/form-fields")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveFormField(@RequestBody FormFields formField) {
        formFieldsRepo.save(formField);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormField Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/form-fields/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateFormField(@PathVariable String id, @RequestBody FormFields formField) {
        FormFields updatedFormField = formFieldsRepo.findFormFieldsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormField not found with id " + id));
        updatedFormField.setForm_id(formField.getForm_id());
        updatedFormField.setForm_section_id(formField.getForm_section_id());
        updatedFormField.setSequence(formField.getSequence());
        updatedFormField.setTemplate(formField.getTemplate());
        updatedFormField.setAttribute(formField.getAttribute());
        updatedFormField.setQuestion(formField.getQuestion());
        updatedFormField.setInput(formField.getInput());
        updatedFormField.setRequired(formField.isRequired());
        updatedFormField.setOptions(formField.getOptions());
        updatedFormField.setFilled(formField.getFilled());
        updatedFormField.setImage(formField.getImage());
        updatedFormField.setJump(formField.getJump());
        updatedFormField.setMap(formField.getMap());
        updatedFormField.setDeleted_at(formField.getDeleted_at());
        updatedFormField.setCreated_at(LocalDateTime.now());
        updatedFormField.setUpdated_at(LocalDateTime.now());
        formFieldsRepo.save(updatedFormField);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormField Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/form-fields/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteFormField(@PathVariable String id) {
        FormFields deleteFormField = formFieldsRepo.findFormFieldsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FormField not found with id " + id));
        formFieldsRepo.delete(deleteFormField);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "FormField Berhasil Dihapus");
        return response;
    }
}
