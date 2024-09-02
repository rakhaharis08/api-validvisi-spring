package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.News;
import api_validvisi.API.Repo.CMSValid.NewsRepo;
import api_validvisi.API.Spesification.CMSValid.NewsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class NewsController {
    @Autowired
    private NewsRepo newsRepo;

    @GetMapping("cms-valid/news/page/{page}")
    public Map<String, Object> getNews(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<News> newsPage = newsRepo.findAll(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", newsPage.getContent());
        return response;
    }

    @GetMapping(value = "cms-valid/news/{id}")
    public Map<String, Object> getNewsById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<News> news = newsRepo.findNewsById(id);

        if (news.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", news.get());
        } else {
            response.put("success", false);
            response.put("message", "News not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/news")
    public Map<String, Object> saveNews(@RequestBody News news) {
        newsRepo.save(news);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "News Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @GetMapping("cms-valid/news/search/page={page}")
    public Map<String, Object> searchNews(
            @PathVariable int page,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) Integer canalId,
            @RequestParam(required = false) Integer subCanalId,
            @RequestParam(required = false) Integer placementId,
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<News> spec = NewsSpecification.filterNews(startDate, endDate, canalId, subCanalId, placementId, title);
        Page<News> newsPage = newsRepo.findAll(spec, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", newsPage.getContent());
        return response;
    }

    @DeleteMapping(value = "cms-valid/news/delete/{id}")
    public Map<String, Object> deleteNews(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<News> news = newsRepo.findNewsById(id);

        if (news.isPresent()) {
            newsRepo.delete(news.get());
            response.put("success", true);
            response.put("message", "News Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "News not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PutMapping(value = "cms-valid/news/update/{id}")
    public Map<String, Object> updateNews(@PathVariable int id, @RequestBody News news) {
        Map<String, Object> response = new HashMap<>();
        Optional<News> existingNews = newsRepo.findNewsById(id);

        if (existingNews.isPresent()) {
            News updatedNews = existingNews.get();
            updatedNews.setTitle(news.getTitle());
            updatedNews.setLower_title(news.getLower_title());
            updatedNews.setTheme_id(news.getTheme_id());
            updatedNews.setDesk_id(news.getDesk_id());
            updatedNews.setCanal_id(news.getCanal_id());
            updatedNews.setSub_canal_id(news.getSub_canal_id());
            updatedNews.setCategory_id(news.getCategory_id());
            updatedNews.setSelect(news.getSelect());
            updatedNews.setReporter(news.getReporter());
            updatedNews.setOutside_reporter(news.getOutside_reporter());
            updatedNews.setPlacement_id(news.getPlacement_id());
            updatedNews.setHeadline(news.getHeadline());
            updatedNews.setSelected(news.getSelected());
            updatedNews.setContent(news.getContent());
            updatedNews.setX_iframe(news.getX_iframe());
            updatedNews.setX_lower_content(news.getX_lower_content());
            updatedNews.setMain_photo(news.getMain_photo());
            updatedNews.setThumbnail(news.getThumbnail());
            updatedNews.setCaption_photo(news.getCaption_photo());
            updatedNews.setSlug(news.getSlug());
            updatedNews.setHastag(news.getHastag());
            updatedNews.setSeo(news.getSeo());
            updatedNews.setKeyword(news.getKeyword());
            updatedNews.setAdd_id(news.getAdd_id());
            updatedNews.setEdit_id(news.getEdit_id());
            updatedNews.setInterviewees_id(news.getInterviewees_id());
            updatedNews.setInstitution_id(news.getInstitution_id());
            updatedNews.setPosition_id(news.getPosition_id());
            updatedNews.setStatus(news.getStatus());
            updatedNews.setPublish_date(news.getPublish_date());
            updatedNews.setUpdated_at(LocalDateTime.now());
            updatedNews.setDeleted_at(news.getDeleted_at());
            updatedNews.setCreated_at(news.getCreated_at());
            updatedNews.setViews(news.getViews());
            updatedNews.setDate(news.getDate());
            updatedNews.setEditor_id(news.getEditor_id());
            updatedNews.setEditor_status(news.getEditor_status());

            newsRepo.save(updatedNews);

            response.put("success", true);
            response.put("message", "News Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "News not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
