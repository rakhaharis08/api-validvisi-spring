package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Billing;
import api_validvisi.API.Repo.AdminVisi.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BillingController {

    @Autowired
    private BillingRepo billingRepo;

    @GetMapping("/admin-visi/billing")
    public Map<String, Object> getBilling() {
        List<Billing> billingList = billingRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", billingList);
        return response;
    }

    @GetMapping("/admin-visi/billing/{id}")
    public Map<String, Object> getBillingById(@PathVariable String id) {
        Optional<Billing> billing = billingRepo.findBillingById(id);
        Map<String, Object> response = new HashMap<>();
        if (billing.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", billing.get());
        } else {
            response.put("success", false);
            response.put("message", "Billing not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("/admin-visi/billing")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveBilling(@RequestBody Billing billing) {
        billingRepo.save(billing);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Billing Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("/admin-visi/billing/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateBilling(@PathVariable String id, @RequestBody Billing billing) {
        Optional<Billing> existingBilling = billingRepo.findBillingById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingBilling.isPresent()) {
            Billing updatedBilling = existingBilling.get();
            updatedBilling.setUser_id(billing.getUser_id());
            updatedBilling.setNomor(billing.getNomor());
            updatedBilling.setDesc(billing.getDesc());
            updatedBilling.setDiscount(billing.getDiscount());
            updatedBilling.setTrx_date(billing.getTrx_date());
            updatedBilling.setTrx_value(billing.getTrx_value());
            updatedBilling.setTrx_total(billing.getTrx_total());
            updatedBilling.setCreated_at(LocalDateTime.now());
            updatedBilling.setStatus(billing.getStatus());
            billingRepo.save(updatedBilling);
            response.put("success", true);
            response.put("message", "Billing Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Billing not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("/admin-visi/billing/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteBilling(@PathVariable String id) {
        Optional<Billing> billing = billingRepo.findBillingById(id);
        Map<String, Object> response = new HashMap<>();
        if (billing.isPresent()) {
            billingRepo.delete(billing.get());
            response.put("success", true);
            response.put("message", "Billing Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Billing not found with id " + id);
            response.put("data", null);
        }
        return response;
    }
}
