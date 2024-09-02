package api_validvisi.API.Controller.AdminVisi;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.AdminVisi.Client;
import api_validvisi.API.Repo.AdminVisi.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {
    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("/admin-visi/clients")
    public Map<String, Object> getClients() {
        List<Client> clientList = clientRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", clientList);
        return response;
    }

    @GetMapping("/admin-visi/clients/{id}")
    public Map<String, Object> getClientById(@PathVariable String id) {
        Client client = clientRepo.findClientById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", client);
        return response;
    }

    @PostMapping("/admin-visi/clients")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> saveClient(@RequestBody Client client) {
        clientRepo.save(client);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Client successfully added");
        return response;
    }

    @PutMapping("/admin-visi/clients/update/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> updateClient(@PathVariable String id, @RequestBody Client client) {
        Client updatedClient = clientRepo.findClientById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
        updatedClient.setName(client.getName());
        updatedClient.setDescription(client.getDescription());
        updatedClient.setPhoto(client.getPhoto());
        updatedClient.setStatus(client.getStatus());
        updatedClient.setCreatedBy(client.getCreatedBy());
        updatedClient.setUpdatedBy(client.getUpdatedBy());
        updatedClient.setCreatedAt(LocalDateTime.now());
        updatedClient.setUpdatedAt(LocalDateTime.now());
        clientRepo.save(updatedClient);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Client successfully updated");
        return response;
    }

    @DeleteMapping("/admin-visi/clients/delete/{id}")
    @Transactional("adminVisiTransactionManager")
    public Map<String, Object> deleteClient(@PathVariable String id) {
        Client deleteClient = clientRepo.findClientById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
        clientRepo.delete(deleteClient);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Client successfully deleted");
        return response;
    }
}
