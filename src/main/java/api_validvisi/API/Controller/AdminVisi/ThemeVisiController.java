package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Theme;
import api_validvisi.API.Repo.AdminVisi.ThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ThemeVisiController {
    @Autowired
    private ThemeRepo themeRepo;

    @GetMapping("/admin-visi/themes")
    public Map<String, Object> getThemesVisi() {
        List<Theme> themesList = themeRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", themesList);
        return response;
    }

    @GetMapping("/admin-visi/themes/{id}")
    public Map<String, Object> getThemesVisiById(@PathVariable String id) {
        Theme theme = themeRepo.findThemeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", theme);
        return response;
    }

    @PostMapping("/admin-visi/themes")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveThemesVisi(@RequestBody Theme theme) {
        themeRepo.save(theme);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Theme Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/themes/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateThemesVisi(@PathVariable String id, @RequestBody Theme theme) {
        Theme updatedTheme = themeRepo.findThemeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theme found with id " + id));
        updatedTheme.setName(theme.getName());
        updatedTheme.setDesc(theme.getDesc());
        updatedTheme.setCreated_by(theme.getCreated_by());
        updatedTheme.setUpdated_by(theme.getUpdated_by());
        updatedTheme.setCreated_at(LocalDateTime.now());
        updatedTheme.setUpdated_at(LocalDateTime.now());
        updatedTheme.setStatus(theme.getStatus());
        themeRepo.save(updatedTheme);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Theme Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/themes/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteThemesVisi(@PathVariable String id) {
        Theme deleteTheme = themeRepo.findThemeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id " + id));
        themeRepo.delete(deleteTheme);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Theme Berhasil Dihapus");
        return response;
    }
}
