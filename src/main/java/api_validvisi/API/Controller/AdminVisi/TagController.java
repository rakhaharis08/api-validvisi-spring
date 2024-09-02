package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Tag;
import api_validvisi.API.Repo.AdminVisi.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TagController {
    @Autowired
    private TagRepo tagRepo;

    @GetMapping("/admin-visi/tags")
    public Map<String, Object> getTags() {
        List<Tag> tagsList = tagRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", tagsList);
        return response;
    }

    @GetMapping("/admin-visi/tags/{id}")
    public Map<String, Object> getTagById(@PathVariable String id) {
        Tag tag = tagRepo.findTagById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", tag);
        return response;
    }

    @PostMapping("/admin-visi/tags")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveTag(@RequestBody Tag tag) {
        tagRepo.save(tag);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Tag Berhasil Ditambahkan");
        return response;
    }

    @PutMapping("/admin-visi/tags/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateTag(@PathVariable String id, @RequestBody Tag tag) {
        Tag updatedTag = tagRepo.findTagById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag found with id " + id));
        updatedTag.setName(tag.getName());
        updatedTag.setDescription(tag.getDescription());
        updatedTag.setSlug(tag.getSlug());
        updatedTag.setMeta_title(tag.getMeta_title());
        updatedTag.setMeta_description(tag.getMeta_description());
        updatedTag.setMeta_keywords(tag.getMeta_keywords());
        updatedTag.setCreated_by(tag.getCreated_by());
        updatedTag.setUpdated_by(tag.getUpdated_by());
        updatedTag.setCreated_at(LocalDateTime.now());
        updatedTag.setUpdated_at(LocalDateTime.now());
        updatedTag.setStatus(tag.getStatus());
        tagRepo.save(updatedTag);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Tag Berhasil Diubah");
        return response;
    }

    @DeleteMapping("/admin-visi/tags/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteTag(@PathVariable String id) {
        Tag deleteTag = tagRepo.findTagById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id " + id));
        tagRepo.delete(deleteTag);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Tag Berhasil Dihapus");
        return response;
    }
}
