package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.Exception.ResourceNotFoundException;
import api_validvisi.API.Model.CMSValid.Employee;
import api_validvisi.API.Projection.CMSValid.RedakturProjection;
import api_validvisi.API.Projection.CMSValid.ReporterProjection;
import api_validvisi.API.Repo.CMSValid.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "cms-valid/employee")
    public Map<String, Object> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", employees);
        return response;
    }

    @GetMapping(value = "cms-valid/employee/{id}")
    public Map<String, Object> getEmployeeById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Employee> employee = employeeRepo.findEmployeeById(id);

        if (employee.isPresent()) {
            response.put("success", true);
            response.put("message", "OK!");
            response.put("data", employee.get());
        } else {
            response.put("success", false);
            response.put("message", "Employee not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @PostMapping(value = "cms-valid/employee")
    public Map<String, Object> saveEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Employee Berhasil Ditambahkan");
        response.put("data", null);
        return response;
    }

    @PutMapping(value = "cms-valid/employee/update/{id}")
    public Map<String, Object> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Map<String, Object> response = new HashMap<>();
        Optional<Employee> existingEmployee = employeeRepo.findEmployeeById(id);

        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setFullname(employee.getFullname());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setPassword(employee.getPassword());
            updatedEmployee.setRole_id(employee.getRole_id());
            updatedEmployee.setPosition_id(employee.getPosition_id());
            updatedEmployee.setDesk_id(employee.getDesk_id());
            updatedEmployee.setSub_desk_id(employee.getSub_desk_id());
            updatedEmployee.setNo_hp(employee.getNo_hp());
            updatedEmployee.setGender(employee.getGender());
            updatedEmployee.setDate_of_birth(employee.getDate_of_birth());
            updatedEmployee.setPlace_of_birth(employee.getPlace_of_birth());
            updatedEmployee.setAddress(employee.getAddress());
            updatedEmployee.setImaage(employee.getImaage());
            updatedEmployee.setRemember_token(employee.getRemember_token());
            updatedEmployee.setStatus(employee.getStatus());
            updatedEmployee.setTheme(employee.getTheme());
            updatedEmployee.setUpdated_at(LocalDateTime.now());
            employeeRepo.save(updatedEmployee);

            response.put("success", true);
            response.put("message", "Users Berhasil Diubah");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Employee not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @DeleteMapping(value = "cms-valid/employee/delete/{id}")
    public Map<String, Object> deleteEmployee(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Employee> deleteEmployee = employeeRepo.findEmployeeById(id);

        if (deleteEmployee.isPresent()) {
            employeeRepo.delete(deleteEmployee.get());
            response.put("success", true);
            response.put("message", "Employee Berhasil Dihapus");
            response.put("data", null);
        } else {
            response.put("success", false);
            response.put("message", "Employee not found with id " + id);
            response.put("data", null);
        }

        return response;
    }

    @GetMapping(value = "cms-valid/redaktur")
    public Map<String, Object> getRedaktur(
            @RequestParam(name = "role1", defaultValue = "3") String role1,
            @RequestParam(name = "role2", defaultValue = "2") String role2,
            @RequestParam(name = "status", defaultValue = "0") Integer status
    ) {
        List<RedakturProjection> redakturList = employeeRepo.findRedakturSummariesByRoleAndStatus(role1, role2, status);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", redakturList);
        return response;
    }

    @GetMapping(value = "cms-valid/reporter")
    public Map<String, Object> getReporter(
            @RequestParam(name = "role1", defaultValue = "4") String role1,
            @RequestParam(name = "status", defaultValue = "0") Integer status
    ) {
        List<ReporterProjection> reporterList = employeeRepo.findReporterSummariesByRoleAndStatus(role1, status);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "OK!");
        response.put("data", reporterList);
        return response;
    }
}
