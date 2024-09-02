package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.ValidRecord;
import api_validvisi.API.Repo.AdminVisi.ValidRecordsRepo;
import api_validvisi.API.Service.AdminVisi.ProductService;
import api_validvisi.API.Service.AdminVisi.StatisticsService;
import api_validvisi.API.Service.AdminVisi.ValidRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ValidRecordsController {
    @Autowired
    private ValidRecordsRepo validRecordsRepo;

    @Autowired
    private ValidRecordsService validRecordsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("admin-visi/valid-records/total-valid-records")
    public Map<String, Object> getTotalValidRecords() {
        Long totalValidRecords = validRecordsService.getTotalValidRecords();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("total_valid_records", totalValidRecords);
        return response;
    }

    @GetMapping("/admin-visi/valid-records")
    public Map<String, Object> getValidRecords() {
        List<ValidRecord> validRecordsList = validRecordsRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", validRecordsList);
        return response;
    }

    @GetMapping("/admin-visi/valid-records/{id}")
    public Map<String, Object> getValidRecordById(@PathVariable String id) {
        ValidRecord validRecord = validRecordsRepo.getValidRecordsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ValidRecord not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", validRecord);
        return response;
    }

    @PostMapping("/admin-visi/valid-records")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveValidRecord(@RequestBody ValidRecord validRecord) {
        validRecordsRepo.save(validRecord);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ValidRecord Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/valid-records/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateValidRecord(@PathVariable String id, @RequestBody ValidRecord validRecord) {
        ValidRecord updatedValidRecord = validRecordsRepo.getValidRecordsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ValidRecord found with id " + id));
        updatedValidRecord.setTheme_id(validRecord.getTheme_id());
        updatedValidRecord.setCanal_id(validRecord.getCanal_id());
        updatedValidRecord.setRubric_id(validRecord.getRubric_id());
        updatedValidRecord.setPlacement_id(validRecord.getPlacement_id());
        updatedValidRecord.setReporter_id(validRecord.getReporter_id());
        updatedValidRecord.setVisitor_id(validRecord.getVisitor_id());
        updatedValidRecord.setLanguage_id(validRecord.getLanguage_id());
        updatedValidRecord.setParent(validRecord.getParent());
        updatedValidRecord.setTitle(validRecord.getTitle());
        updatedValidRecord.setLower_title(validRecord.getLower_title());
        updatedValidRecord.setContent(validRecord.getContent());
        updatedValidRecord.setCaption_photo(validRecord.getCaption_photo());
        updatedValidRecord.setMain_photo(validRecord.getMain_photo());
        updatedValidRecord.setThumbnail(validRecord.getThumbnail());
        updatedValidRecord.setSlug(validRecord.getSlug());
        updatedValidRecord.setKeyword(validRecord.getKeyword());
        updatedValidRecord.setPublish_date(validRecord.getPublish_date());
        updatedValidRecord.setIs_recomend(validRecord.getIs_recomend());
        updatedValidRecord.setCount_read(validRecord.getCount_read());
        updatedValidRecord.setCreated_by(validRecord.getCreated_by());
        updatedValidRecord.setUpdated_by(validRecord.getUpdated_by());
        updatedValidRecord.setCreated_at(LocalDateTime.now());
        updatedValidRecord.setUpdated_at(LocalDateTime.now());
        updatedValidRecord.setStatus(validRecord.getStatus());
        validRecordsRepo.save(updatedValidRecord);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ValidRecord Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/valid-records/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteValidRecord(@PathVariable String id) {
        ValidRecord deleteValidRecord = validRecordsRepo.getValidRecordsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ValidRecord not found with id " + id));
        validRecordsRepo.delete(deleteValidRecord);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "ValidRecord Berhasil Dihapus");
        return response;
    }

    @GetMapping("admin-visi/project-status")
    public Map<String, Double> getPercentages() {
        Long totalValidRecords = validRecordsService.getTotalValidRecords();
        Long totalStatistics = statisticsService.getTotalStatistic();
        Long totalProduct = productService.getTotalProduct();

        Long total = totalValidRecords + totalStatistics + totalProduct;

        double percentageValidRecords = (total == 0) ? 0 : (double) totalValidRecords / total * 100;
        double percentageStatistics = (total == 0) ? 0 : (double) totalStatistics / total * 100;
        double percentageProduct = (total == 0) ? 0 : (double) totalProduct / total * 100;

        Map<String, Double> percentages = new HashMap<>();
        percentages.put("Valid Records", percentageValidRecords);
        percentages.put("Statistic", percentageStatistics);
        percentages.put("Product", percentageProduct);

        return percentages;
    }
}
