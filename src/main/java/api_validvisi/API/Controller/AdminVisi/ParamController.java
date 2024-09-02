package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Param;
import api_validvisi.API.Repo.AdminVisi.ParamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamController {
    @Autowired
    private ParamRepo paramRepo;

    @GetMapping("/admin-visi/params")
    public Map<String, Object> getParams() {
        List<Param> paramList = paramRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", paramList);
        return response;
    }

    @GetMapping("/admin-visi/params/{id}")
    public Map<String, Object> getParamById(@PathVariable String id) {
        Param param = paramRepo.findParamById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Param not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", param);
        return response;
    }

    @PostMapping("/admin-visi/params")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveParam(@RequestBody Param param) {
        paramRepo.save(param);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Param successfully added");
        return response;
    }

    @PutMapping("/admin-visi/params/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateParam(@PathVariable String id, @RequestBody Param param) {
        Param updatedParam = paramRepo.findParamById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Param not found with id " + id));
        updatedParam.setName(param.getName());
        updatedParam.setDesc(param.getDesc());
        updatedParam.setCreated_by(param.getCreated_by());
        updatedParam.setUpdated_by(param.getUpdated_by());
        updatedParam.setCreated_at(LocalDateTime.now());
        updatedParam.setUpdated_at(LocalDateTime.now());
        updatedParam.setStatus(param.getStatus());
        paramRepo.save(updatedParam);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Param successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/params/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteParam(@PathVariable String id) {
        Param deleteParam = paramRepo.findParamById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Param not found with id " + id));
        paramRepo.delete(deleteParam);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Param successfully deleted");
        return response;
    }
}
