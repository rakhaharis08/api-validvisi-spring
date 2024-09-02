package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Model.CMSValid.ParamValid;
import api_validvisi.API.Model.CMSValid.ParamDetailValid;
import api_validvisi.API.Repo.CMSValid.ParamDetailValidRepo;
import api_validvisi.API.Repo.CMSValid.ParamValidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ParamValidController {
    @Autowired
    private ParamValidRepo paramValidRepo;

    @GetMapping(value="cms-valid/parameter")
    public Map<String, Object> getParameter(){
        List<ParamValid> paramValids = paramValidRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", paramValids);
        return response;
    }

    @GetMapping(value="cms-valid/parameter/{id}")
    public Map<String, Object> getParameterById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamValid> param = paramValidRepo.findParamById(id);

        if (param.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", param.get());
        } else {
            response.put("success", false);
            response.put("message", "Parameter not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/parameter")
    public Map<String, Object> saveParameter(@RequestBody ParamValid paramValid){
        paramValidRepo.save(paramValid);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Parameter Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value= "cms-valid/parameter/update/{id}")
    public Map<String, Object> updateParameter (@PathVariable int id, @RequestBody ParamValid paramValid){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamValid> existingParam = paramValidRepo.findParamById(id);

        if (existingParam.isPresent()) {
            ParamValid updatedParamValid = existingParam.get();
            updatedParamValid.setName(paramValid.getName());
            updatedParamValid.setDescription(paramValid.getDescription());
            updatedParamValid.setStatus(paramValid.getStatus());
            paramValidRepo.save(updatedParamValid);
            response.put("success", true);
            response.put("message", "Parameter Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Parameter not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/parameter/delete/{id}")
    public Map<String, Object> deleteParameter(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamValid> param = paramValidRepo.findParamById(id);

        if (param.isPresent()) {
            paramValidRepo.delete(param.get());
            response.put("success", true);
            response.put("message", "Parameter Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Parameter not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @Autowired
    private ParamDetailValidRepo paramDetailRepo;

    @GetMapping(value="cms-valid/parameter-detail")
    public Map<String, Object> getParameterDetail(){
        List<ParamDetailValid> paramDetailValids = paramDetailRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", paramDetailValids);
        return response;
    }

    @GetMapping(value="cms-valid/parameter-detail/{id}")
    public Map<String, Object> getParameterDetailById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamDetailValid> paramDetail = paramDetailRepo.findParamDetailById(id);

        if (paramDetail.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", paramDetail.get());
        } else {
            response.put("success", false);
            response.put("message", "Parameter Detail not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @GetMapping(value="cms-valid/parameter-detail/param/{paramId}")
    public Map<String, Object> getParameterDetailByParamId(@PathVariable int paramId) {
        List<ParamDetailValid> paramDetailValids = paramDetailRepo.findByParamId(paramId);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", paramDetailValids);
        return response;
    }

    @PutMapping(value= "cms-valid/parameter-detail/update/{id}")
    public Map<String, Object> updateParameterDetail (@PathVariable int id, @RequestBody ParamDetailValid paramDetailValid){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamDetailValid> existingParamDetail = paramDetailRepo.findParamDetailById(id);

        if (existingParamDetail.isPresent()) {
            ParamDetailValid updatedParamDetailValid = existingParamDetail.get();
            updatedParamDetailValid.setName(paramDetailValid.getName());
            updatedParamDetailValid.setDescription(paramDetailValid.getDescription());
            updatedParamDetailValid.setStatus(paramDetailValid.getStatus());
            paramDetailRepo.save(updatedParamDetailValid);
            response.put("success", true);
            response.put("message", "Parameter Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Parameter Detail not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/parameter-detail/delete/{id}")
    public Map<String, Object> deleteParameterDetail(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<ParamDetailValid> paramDetail = paramDetailRepo.findParamDetailById(id);

        if (paramDetail.isPresent()) {
            paramDetailRepo.delete(paramDetail.get());
            response.put("success", true);
            response.put("message", "Parameter Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Parameter Detail not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
