package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Statistics;
import api_validvisi.API.Repo.AdminVisi.StatisticsRepo;
import api_validvisi.API.Service.AdminVisi.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StatisticsController {
    @Autowired
    private StatisticsRepo statisticRepo;

    @Autowired
    private StatisticsService statisticService;

    @GetMapping("/admin-visi/statistics")
    public Map<String, Object> getStatistics() {
        List<Statistics> statisticsList = statisticRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", statisticsList);
        return response;
    }

    @GetMapping("/admin-visi/statistics/{id}")
    public Map<String, Object> getStatisticsById(@PathVariable String id) {
        Statistics statistics = statisticRepo.findStatisticsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", statistics);
        return response;
    }

    @PostMapping("/admin-visi/statistics")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveStatistics(@RequestBody Statistics statistics) {
        statisticRepo.save(statistics);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Statistics Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/statistics/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateStatistics(@PathVariable String id, @RequestBody Statistics statistics) {
        Statistics updatedStatistics = statisticRepo.findStatisticsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics found with id " + id));
        updatedStatistics.setTheme_id(statistics.getTheme_id());
        updatedStatistics.setCanal_id(statistics.getCanal_id());
        updatedStatistics.setRubric_id(statistics.getRubric_id());
        updatedStatistics.setPlacement_id(statistics.getPlacement_id());
        updatedStatistics.setReporter_id(statistics.getReporter_id());
        updatedStatistics.setVisitor_id(statistics.getVisitor_id());
        updatedStatistics.setParent(statistics.getParent());
        updatedStatistics.setLanguage_id(statistics.getLanguage_id());
        updatedStatistics.setTitle(statistics.getTitle());
        updatedStatistics.setLower_title(statistics.getLower_title());
        updatedStatistics.setContent(statistics.getContent());
        updatedStatistics.setCaption_photo(statistics.getCaption_photo());
        updatedStatistics.setMain_photo(statistics.getMain_photo());
        updatedStatistics.setThumbnail(statistics.getThumbnail());
        updatedStatistics.setSlug(statistics.getSlug());
        updatedStatistics.setKeyword(statistics.getKeyword());
        updatedStatistics.setPublish_date(statistics.getPublish_date());
        updatedStatistics.setIs_recomend(statistics.getIs_recomend());
        updatedStatistics.setCount_read(statistics.getCount_read());
        updatedStatistics.setCreated_by(statistics.getCreated_by());
        updatedStatistics.setUpdated_by(statistics.getUpdated_by());
        updatedStatistics.setCreated_at(LocalDateTime.now());
        updatedStatistics.setUpdated_at(LocalDateTime.now());
        updatedStatistics.setStatus(statistics.getStatus());
        statisticRepo.save(updatedStatistics);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Statistics Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/statistics/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteStatistics(@PathVariable String id) {
        Statistics deleteStatistics = statisticRepo.findStatisticsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Statistics not found with id " + id));
        statisticRepo.delete(deleteStatistics);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Statistics Berhasil Dihapus");
        return response;
    }

    @GetMapping("/admin-visi/statistic/total-statistic")
    public Map<String, Object> getTotalStatistic() {
        Long totalStatistic = statisticService.getTotalStatistic();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("total_statistic", totalStatistic);
        return response;
    }
}
