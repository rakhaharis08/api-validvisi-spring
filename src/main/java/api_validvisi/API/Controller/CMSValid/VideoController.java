package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Video;
import api_validvisi.API.Repo.CMSValid.VideoRepo;
import api_validvisi.API.Spesification.CMSValid.VideoSpecification;
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
public class VideoController {

    @Autowired
    private VideoRepo videoRepo;

    @GetMapping("cms-valid/video/page/{page}")
    public Map<String, Object> getVideo(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<Video> videoPage = videoRepo.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", videoPage.getContent());
        return response;
    }

    @GetMapping(value="cms-valid/video/{id}")
    public Map<String, Object> getVideoById(@PathVariable int id){
        Optional<Video> video = videoRepo.findVideoById(id);

        Map<String, Object> response = new HashMap<>();
        if (video.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", video.get());
        } else {
            response.put("success", false);
            response.put("message", "Video not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/video")
    public Map<String, Object> saveVideo(@RequestBody Video video){
        videoRepo.save(video);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Video Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @GetMapping("cms-valid/video/search/page={page}")
    public Map<String, Object> searchVideo(
            @PathVariable int page,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) Integer canalId,
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<Video> spec = VideoSpecification.filterVideo(startDate, endDate, canalId, title);
        Page<Video> videoPage = videoRepo.findAll(spec, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", videoPage.getContent());
        return response;
    }

    @DeleteMapping(value = "cms-valid/video/delete/{id}")
    public Map<String, Object> deleteVideo(@PathVariable int id){
        Optional<Video> video = videoRepo.findVideoById(id);

        Map<String, Object> response = new HashMap<>();
        if (video.isPresent()) {
            videoRepo.delete(video.get());
            response.put("success", true);
            response.put("message", "Video Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Video not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PutMapping(value= "cms-valid/videos/update/{id}")
    public Map<String, Object> updateVideo(@PathVariable int id, @RequestBody Video video) {
        Optional<Video> existingVideo = videoRepo.findVideoById(id);

        Map<String, Object> response = new HashMap<>();
        if (existingVideo.isPresent()) {
            Video updatedVideo = existingVideo.get();
            updatedVideo.setTitle(video.getTitle());
            updatedVideo.setDescription(video.getDescription());
            updatedVideo.setIframe(video.getIframe());
            updatedVideo.setThumbnail(video.getThumbnail());
            updatedVideo.setKeyword(video.getKeyword());
            updatedVideo.setEmployee_id(video.getEmployee_id());
            updatedVideo.setSelected_id(video.getSelected_id());
            updatedVideo.setCanal_id(video.getCanal_id());
            updatedVideo.setSub_canal_id(video.getSub_canal_id());
            updatedVideo.setStatus(video.getStatus());
            updatedVideo.setUpdated_at(LocalDateTime.now());
            updatedVideo.setSlug(video.getSlug());
            updatedVideo.setPublish_date(video.getPublish_date());
            updatedVideo.setSelected(video.getSelected());
            updatedVideo.setCategory_id(video.getCategory_id());
            updatedVideo.setCreatead_at(video.getCreatead_at());

            videoRepo.save(updatedVideo);
            response.put("success", true);
            response.put("message", "Video Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Video not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
