package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.BillingDetail;
import api_validvisi.API.Repo.AdminVisi.BillingDetailRepo;
import api_validvisi.API.Service.AdminVisi.BillingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BillingDetailController {

    @Autowired
    private BillingDetailRepo billingDetailRepo;

    @Autowired
    private BillingDetailService billingDetailService;

    @GetMapping("admin-visi/billing-detail")
    public Map<String, Object> getBillingDetail() {
        List<BillingDetail> billingDetailList = billingDetailRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", billingDetailList);
        return response;
    }

    @GetMapping("admin-visi/billing-detail/{id}")
    public Map<String, Object> getBillingDetailById(@PathVariable String id) {
        Optional<BillingDetail> billingDetail = billingDetailRepo.findBillingDetailById(id);
        Map<String, Object> response = new HashMap<>();
        if (billingDetail.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", billingDetail.get());
        } else {
            response.put("success", false);
            response.put("message", "Billing Detail not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @PostMapping("admin-visi/billing-detail")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveBillingDetail(@RequestBody BillingDetail billingDetail) {
        billingDetailRepo.save(billingDetail);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Billing Detail Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping("admin-visi/billing-detail/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateBillingDetail(@PathVariable String id, @RequestBody BillingDetail billingDetail) {
        Optional<BillingDetail> existingBillingDetail = billingDetailRepo.findBillingDetailById(id);
        Map<String, Object> response = new HashMap<>();
        if (existingBillingDetail.isPresent()) {
            BillingDetail updatedBillingDetail = existingBillingDetail.get();
            updatedBillingDetail.setBilling_id(billingDetail.getBilling_id());
            updatedBillingDetail.setProduct_id(billingDetail.getProduct_id());
            updatedBillingDetail.setProduct_type(billingDetail.getProduct_type());
            updatedBillingDetail.setVoucher_id(billingDetail.getVoucher_id());
            updatedBillingDetail.setQty(billingDetail.getQty());
            updatedBillingDetail.setTrx_value(billingDetail.getTrx_value());
            updatedBillingDetail.setDiscount(billingDetail.getDiscount());
            updatedBillingDetail.setTrx_total(billingDetail.getTrx_total());
            updatedBillingDetail.setUpdated_at(LocalDateTime.now());
            updatedBillingDetail.setStatus(billingDetail.getStatus());
            billingDetailRepo.save(updatedBillingDetail);
            response.put("success", true);
            response.put("message", "Billing Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Billing Detail not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @DeleteMapping("admin-visi/billing-detail/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteBillingDetail(@PathVariable String id) {
        Optional<BillingDetail> billingDetail = billingDetailRepo.findBillingDetailById(id);
        Map<String, Object> response = new HashMap<>();
        if (billingDetail.isPresent()) {
            billingDetailRepo.delete(billingDetail.get());
            response.put("success", true);
            response.put("message", "Billing Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Billing Detail not found with id " + id);
            response.put("data", null);
        }
        return response;
    }

    @GetMapping("admin-visi/total-trx")
    public Map<String, Object> getTotalTrxTotal() {
        Double totalTrxTotal = billingDetailService.getTotalTrxTotal();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", totalTrxTotal);
        return response;
    }

    @GetMapping("admin-visi/total-trx-month")
    public Map<String, Object> getMonthlyTotals() {
        String status = "d3c50344-e690-4733-b832-bd9145bd21af";
        List<Object[]> results = billingDetailRepo.findMonthlyTotalsByStatus(status);
        Map<String, Double> formattedTotals = new HashMap<>();

        // Inisialisasi default untuk setiap bulan
        for (int month = 1; month <= 12; month++) {
            formattedTotals.put(getMonthName(month), 0.0);
        }

        // Proses hasil query
        for (Object[] result : results) {
            Integer month = ((Number) result[0]).intValue();
            Double total = ((Number) result[1]).doubleValue();
            formattedTotals.put(getMonthName(month), total);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", formattedTotals);
        return response;
    }

    private String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "";
        }
    }
}
