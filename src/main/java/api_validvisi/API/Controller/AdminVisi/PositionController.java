package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Model.AdminVisi.ParamDetailVisi;
import api_validvisi.API.Repo.AdminVisi.ParamDetailVisiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PositionController {

    @Autowired
    private ParamDetailVisiRepo paramDetailVisiRepo;

    @GetMapping("/admin-visi/position")
    public Map<String, Object> getPosition() {
        String paramId = "5ef3de15-f9d2-4100-92cc-43d88e6c50db";
        List<ParamDetailVisi> banks = paramDetailVisiRepo.findByParamId(paramId);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", banks);
        return response;
    }
}
