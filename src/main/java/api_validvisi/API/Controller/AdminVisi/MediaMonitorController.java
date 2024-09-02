package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Model.AdminVisi.MediaMonitor;
import api_validvisi.API.Repo.AdminVisi.MediaMonitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MediaMonitorController {
    @Autowired
    private MediaMonitorRepo mediaMonitorRepo;

    @GetMapping("/admin-visi/media-monitor")
    public Map<String, Object> getMediaMonitor() {
        List<MediaMonitor> mediaMonitorList = mediaMonitorRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", mediaMonitorList);
        return response;
    }

    @GetMapping("/admin-visi/media-monitor/count-by-media-type")
    public Map<String, Object> getCountByMediaType() {
        long cetakCount = mediaMonitorRepo.countByMediaType("cetak");
        long onlineCount = mediaMonitorRepo.countByMediaType("online");
        long sosialCount = mediaMonitorRepo.countByMediaType("sosial");

        Map<String, Long> countByType = new HashMap<>();
        countByType.put("cetak", cetakCount);
        countByType.put("online", onlineCount);
        countByType.put("sosial", sosialCount);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", countByType);
        return response;
    }
}
