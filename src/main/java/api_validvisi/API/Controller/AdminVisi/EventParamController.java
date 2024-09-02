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
public class EventParamController {

    @Autowired
    private ParamDetailVisiRepo paramDetailVisiRepo;

    @GetMapping("/admin-visi/event-param")
    public Map<String, Object> getEventParam() {
        String paramId = "290c78d4-9d9f-4ea9-87de-e0c76f52763c";
        List<ParamDetailVisi> banks = paramDetailVisiRepo.findByParamId(paramId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", banks);
        return response;
    }
}
