package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Voucher;
import api_validvisi.API.Repo.AdminVisi.VoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VoucherController {
    @Autowired
    private VoucherRepo voucherRepo;

    @GetMapping("/admin-visi/vouchers")
    public Map<String, Object> getVouchers() {
        List<Voucher> voucherList = voucherRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", voucherList);
        return response;
    }

    @GetMapping("/admin-visi/vouchers/{id}")
    public Map<String, Object> getVoucherById(@PathVariable String id) {
        Voucher voucher = voucherRepo.findVoucherById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", voucher);
        return response;
    }

    @PostMapping("/admin-visi/vouchers")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveVoucher(@RequestBody Voucher voucher) {
        voucherRepo.save(voucher);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Voucher successfully added");
        return response;
    }

    @PutMapping("/admin-visi/vouchers/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateVoucher(@PathVariable String id, @RequestBody Voucher voucher) {
        Voucher updatedVoucher = voucherRepo.findVoucherById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found with id " + id));
        updatedVoucher.setCode(voucher.getCode());
        updatedVoucher.setName(voucher.getName());
        updatedVoucher.setDesc(voucher.getDesc());
        updatedVoucher.setDisc_pct(voucher.getDisc_pct());
        updatedVoucher.setFrequency(voucher.getFrequency());
        updatedVoucher.setLimit(voucher.getLimit());
        updatedVoucher.setCreated_by(voucher.getCreated_by());
        updatedVoucher.setUpdated_by(voucher.getUpdated_by());
        updatedVoucher.setPublish_date(voucher.getPublish_date());
        updatedVoucher.setExpired_date(voucher.getExpired_date());
        updatedVoucher.setCreated_at(LocalDateTime.now());
        updatedVoucher.setUpdated_at(LocalDateTime.now());
        updatedVoucher.setStatus(voucher.getStatus());
        voucherRepo.save(updatedVoucher);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Voucher successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/vouchers/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteVoucher(@PathVariable String id) {
        Voucher deleteVoucher = voucherRepo.findVoucherById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher not found with id " + id));
        voucherRepo.delete(deleteVoucher);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Voucher successfully deleted");
        return response;
    }
}
