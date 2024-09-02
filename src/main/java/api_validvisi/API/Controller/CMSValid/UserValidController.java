package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Users;
import api_validvisi.API.Repo.CMSValid.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserValidController {

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping(value="cms-valid/users")
    public Map<String, Object> getUsers(){
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", usersRepo.findAll());
        return response;
    }

    @GetMapping(value="cms-valid/users/{id}")
    public Map<String, Object> getUsersById(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Users> user = usersRepo.findUsersById(id);

        if (user.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", user.get());
        } else {
            response.put("success", false);
            response.put("message", "Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/users")
    public Map<String, Object> saveUsers(@RequestBody Users users){
        usersRepo.save(users);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Users Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value= "cms-valid/users/update/{id}")
    public Map<String, Object> updateUsers (@PathVariable int id, @RequestBody Users users){
        Map<String, Object> response = new HashMap<>();
        Optional<Users> existingUser = usersRepo.findUsersById(id);

        if (existingUser.isPresent()) {
            Users updatedUsers = existingUser.get();
            updatedUsers.setFullname(users.getFullname());
            updatedUsers.setEmail(users.getEmail());
            updatedUsers.setPassword(users.getPassword());
            updatedUsers.setNo_hp(users.getNo_hp());
            updatedUsers.setGender(users.getGender());
            updatedUsers.setDate_of_birth(users.getDate_of_birth());
            updatedUsers.setPlace_of_birth(users.getPlace_of_birth());
            updatedUsers.setAddress(users.getAddress());
            updatedUsers.setImaage(users.getImaage());
            updatedUsers.setRemember_token(users.getRemember_token());
            updatedUsers.setStatus(users.getStatus());
            updatedUsers.setUpdated_at(LocalDateTime.now());
            usersRepo.save(updatedUsers);

            response.put("success", true);
            response.put("message", "Users Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/users/delete/{id}")
    public Map<String, Object> deleteUsers(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        Optional<Users> user = usersRepo.findUsersById(id);

        if (user.isPresent()) {
            usersRepo.delete(user.get());
            response.put("success", true);
            response.put("message", "Users Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Users not found with id " + id);
            response.put("data", null);
        }

        return response;
    }
}
