package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Page;
import api_validvisi.API.Repo.AdminVisi.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PageController {
    @Autowired
    private PageRepo pageRepo;

    @GetMapping("/admin-visi/pages")
    public Map<String, Object> getPages() {
        List<Page> pageList = pageRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", pageList);
        return response;
    }

    @GetMapping("/admin-visi/pages/{id}")
    public Map<String, Object> getPageById(@PathVariable String id) {
        Page page = pageRepo.findPageById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", page);
        return response;
    }

    @PostMapping("/admin-visi/pages")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> savePage(@RequestBody Page page) {
        pageRepo.save(page);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Page successfully added");
        return response;
    }

    @PutMapping("/admin-visi/pages/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updatePage(@PathVariable String id, @RequestBody Page page) {
        Page updatedPage = pageRepo.findPageById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found with id " + id));
        updatedPage.setPageTypeId(page.getPageTypeId());
        updatedPage.setSubPageTypeId(page.getSubPageTypeId());
        updatedPage.setFooterPageTypeId(page.getFooterPageTypeId());
        updatedPage.setTitle(page.getTitle());
        updatedPage.setLowerTitle(page.getLowerTitle());
        updatedPage.setDesc(page.getDesc());
        updatedPage.setValue1(page.getValue1());
        updatedPage.setValue2(page.getValue2());
        updatedPage.setValue3(page.getValue3());
        updatedPage.setValue4(page.getValue4());
        updatedPage.setValue5(page.getValue5());
        updatedPage.setSlug(page.getSlug());
        updatedPage.setMetaTitle(page.getMetaTitle());
        updatedPage.setMetaDescription(page.getMetaDescription());
        updatedPage.setMetaKeywords(page.getMetaKeywords());
        updatedPage.setCreatedBy(page.getCreatedBy());
        updatedPage.setUpdatedBy(page.getUpdatedBy());
        updatedPage.setCreatedAt(LocalDateTime.now());
        updatedPage.setUpdatedAt(LocalDateTime.now());
        updatedPage.setStatus(page.getStatus());
        pageRepo.save(updatedPage);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Page successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/pages/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deletePage(@PathVariable String id) {
        Page deletePage = pageRepo.findPageById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page not found with id " + id));
        pageRepo.delete(deletePage);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Page successfully deleted");
        return response;
    }
}
