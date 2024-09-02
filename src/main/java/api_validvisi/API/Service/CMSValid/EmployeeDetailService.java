package api_validvisi.API.Service.CMSValid;

import api_validvisi.API.Model.CMSValid.Employee;
import api_validvisi.API.Repo.CMSValid.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> employee = repo.findEmployeeByEmail(email);

        if (employee.isPresent()) {
            Employee emp = employee.get();
            return User.withUsername(emp.getEmail())
                    .password(emp.getPassword())
                    .roles(emp.getRole_id())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
