package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.UserComment;
import api_validvisi.API.Repo.AdminVisi.UserCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserCommentController {
    @Autowired
    private UserCommentRepo userCommentRepo;

    @GetMapping("/admin-visi/user-comments")
    public Map<String, Object> getUserComments() {
        List<UserComment> userCommentList = userCommentRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", userCommentList);
        return response;
    }

    @GetMapping("/admin-visi/user-comments/{id}")
    public Map<String, Object> getUserCommentById(@PathVariable String id) {
        UserComment userComment = userCommentRepo.findUserCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserComment not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", userComment);
        return response;
    }

    @PostMapping("/admin-visi/user-comments")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveUserComment(@RequestBody UserComment userComment) {
        userCommentRepo.save(userComment);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserComment successfully added");
        return response;
    }

    @PutMapping("/admin-visi/user-comments/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateUserComment(@PathVariable String id, @RequestBody UserComment userComment) {
        UserComment updatedUserComment = userCommentRepo.findUserCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserComment not found with id " + id));
        updatedUserComment.setUser_id(userComment.getUser_id());
        updatedUserComment.setComment_type_id(userComment.getComment_type_id());
        updatedUserComment.setObject_id(userComment.getObject_id());
        updatedUserComment.setContent(userComment.getContent());
        updatedUserComment.setParent(userComment.getParent());
        updatedUserComment.setCreated_by(userComment.getCreated_by());
        updatedUserComment.setUpdated_by(userComment.getUpdated_by());
        updatedUserComment.setCreated_at(LocalDateTime.now());
        updatedUserComment.setUpdated_at(LocalDateTime.now());
        updatedUserComment.setStatus(userComment.getStatus());
        userCommentRepo.save(updatedUserComment);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserComment successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/user-comments/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteUserComment(@PathVariable String id) {
        UserComment deleteUserComment = userCommentRepo.findUserCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserComment not found with id " + id));
        userCommentRepo.delete(deleteUserComment);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "UserComment successfully deleted");
        return response;
    }
}
