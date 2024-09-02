package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Photo;
import api_validvisi.API.Repo.CMSValid.PhotoRepo;
import api_validvisi.API.Spesification.CMSValid.PhotoSpecification;
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
public class PhotoController {

    @Autowired
    private PhotoRepo photoRepo;

    @GetMapping("cms-valid/photo/page/{page}")
    public Map<String, Object> getPhoto(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<Photo> photoPage = photoRepo.findAll(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", photoPage.getContent());
        return response;
    }

    @GetMapping(value="cms-valid/photo/{id}")
    public Map<String, Object> getPhotoById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Photo> photo = photoRepo.findPhotoById(id);

        if (photo.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", photo.get());
        } else {
            response.put("success", false);
            response.put("message", "Photo not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/photo")
    public Map<String, Object> savePhoto(@RequestBody Photo photo){
        photoRepo.save(photo);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Photo Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @GetMapping("cms-valid/photo/search/page={page}")
    public Map<String, Object> searchPhoto(
            @PathVariable int page,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) Integer canalId,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Specification<Photo> spec = PhotoSpecification.filterPhoto(startDate, endDate, canalId, description);
        Page<Photo> photoPage = photoRepo.findAll(spec, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", photoPage.getContent());
        return response;
    }

    @DeleteMapping(value = "cms-valid/photo/delete/{id}")
    public Map<String, Object> deletePhoto(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Photo> photo = photoRepo.findPhotoById(id);

        if (photo.isPresent()) {
            photoRepo.delete(photo.get());
            response.put("success", true);
            response.put("message", "Photo Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Photo not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PutMapping(value= "cms-valid/photo/update/{id}")
    public Map<String, Object> updatePhoto(@PathVariable int id, @RequestBody Photo photo) {
        Map<String, Object> response = new HashMap<>();
        Optional<Photo> existingPhoto = photoRepo.findPhotoById(id);

        if (existingPhoto.isPresent()) {
            Photo updatedPhoto = existingPhoto.get();
            updatedPhoto.setTitle(photo.getTitle());
            updatedPhoto.setDescription(photo.getDescription());
            updatedPhoto.setKeyword(photo.getKeyword());
            updatedPhoto.setImage(photo.getImage());
            updatedPhoto.setThumbnail(photo.getThumbnail());
            updatedPhoto.setSlug(photo.getSlug());
            updatedPhoto.setCanal_id(photo.getCanal_id());
            updatedPhoto.setCategory_id(photo.getCategory_id());
            updatedPhoto.setEmployee_id(photo.getEmployee_id());
            updatedPhoto.setSource(photo.getSource());
            updatedPhoto.setStatus(photo.getStatus());
            updatedPhoto.setCreated_at(photo.getCreated_at());
            updatedPhoto.setUpdated_at(LocalDateTime.now());
            updatedPhoto.setSelected(photo.getSelected());

            photoRepo.save(updatedPhoto);

            response.put("success", true);
            response.put("message", "Photo Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Photo not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
