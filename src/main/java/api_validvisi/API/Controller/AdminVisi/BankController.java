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
public class BankController {

    @Autowired
    private ParamDetailVisiRepo paramDetailVisiRepo;

    @GetMapping("/admin-visi/bank")
    public Map<String, Object> getBanks() {
        String paramId = "3cedec41-7697-4ea3-8e6b-8e22055a2d53";
        List<ParamDetailVisi> banks = paramDetailVisiRepo.findByParamId(paramId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", banks);
        return response;
    }
}
