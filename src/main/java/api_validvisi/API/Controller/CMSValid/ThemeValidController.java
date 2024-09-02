package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Themes;
import api_validvisi.API.Repo.CMSValid.ThemesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ThemeValidController {

    @Autowired
    private ThemesRepo themesRepo;

    @GetMapping(value="cms-valid/themes")
    public Map<String, Object> getThemes(){
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", themesRepo.findAll());
        return response;
    }

    @GetMapping(value="cms-valid/themes/{id}")
    public Map<String, Object> getThemesById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Themes> theme = themesRepo.findThemesById(id);

        if (theme.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", theme.get());
        } else {
            response.put("success", false);
            response.put("message", "Themes not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/themes")
    public Map<String, Object> saveThemes(@RequestBody Themes themes){
        themesRepo.save(themes);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Themes Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value= "cms-valid/themes/update/{id}")
    public Map<String, Object> updateThemes (@PathVariable int id, @RequestBody Themes themes){
        Map<String, Object> response = new HashMap<>();
        Optional<Themes> existingThemes = themesRepo.findThemesById(id);

        if (existingThemes.isPresent()) {
            Themes updatedThemes = existingThemes.get();
            updatedThemes.setEmployee_id(themes.getEmployee_id());
            updatedThemes.setName(themes.getName());
            updatedThemes.setStatus(themes.getStatus());
            updatedThemes.setUpdated_at(LocalDateTime.now());
            updatedThemes.setSlug(themes.getSlug());
            themesRepo.save(updatedThemes);

            response.put("success", true);
            response.put("message", "Themes Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Themes not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/themes/delete/{id}")
    public Map<String, Object> deleteThemes(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Themes> theme = themesRepo.findThemesById(id);

        if (theme.isPresent()) {
            themesRepo.delete(theme.get());
            response.put("success", true);
            response.put("message", "Themes Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Themes not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
