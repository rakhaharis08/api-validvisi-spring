package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.GuestUsers;
import api_validvisi.API.Repo.CMSValid.GuestUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class GuestUsersController {
    @Autowired
    private GuestUsersRepo guestUsersRepo;

    @GetMapping(value = "cms-valid/guest_users")
    public Map<String, Object> getGuestUsers() {
        List<GuestUsers> guestUsersList = guestUsersRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", guestUsersList);
        return response;
    }

    @GetMapping(value = "cms-valid/guest_users/{id}")
    public Map<String, Object> getGuestUsersById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<GuestUsers> guestUser = guestUsersRepo.findGuestUsersById(id);

        if (guestUser.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", guestUser.get());
        } else {
            response.put("success", false);
            response.put("message", "Guest Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/guest_users")
    public Map<String, Object> saveGuestUsers(@RequestBody GuestUsers guestUsers) {
        guestUsersRepo.save(guestUsers);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Guest Users Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value = "cms-valid/guest_users/update/{id}")
    public Map<String, Object> updateGuestUsers(@PathVariable int id, @RequestBody GuestUsers guestUsers) {
        Map<String, Object> response = new HashMap<>();
        Optional<GuestUsers> existingGuestUser = guestUsersRepo.findGuestUsersById(id);

        if (existingGuestUser.isPresent()) {
            GuestUsers updatedGuestUser = existingGuestUser.get();
            updatedGuestUser.setName(guestUsers.getName());
            updatedGuestUser.setPosition(guestUsers.getPosition());
            updatedGuestUser.setUpdated_at(LocalDateTime.now());
            updatedGuestUser.setStatus(guestUsers.getStatus());
            guestUsersRepo.save(updatedGuestUser);

            response.put("success", true);
            response.put("message", "Guest Users Detail Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Guest Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/guest_users/delete/{id}")
    public Map<String, Object> deleteGuestUsers(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<GuestUsers> guestUserToDelete = guestUsersRepo.findGuestUsersById(id);

        if (guestUserToDelete.isPresent()) {
            guestUsersRepo.delete(guestUserToDelete.get());
            response.put("success", true);
            response.put("message", "Guest Users Detail Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Guest Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
