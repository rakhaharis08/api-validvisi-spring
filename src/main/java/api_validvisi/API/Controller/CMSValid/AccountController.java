package api_validvisi.API.Controller.CMSValid;

import api_validvisi.API.DTO.CMSValid.LoginDTO;
import api_validvisi.API.Model.CMSValid.Employee;
import api_validvisi.API.Repo.CMSValid.EmployeeRepo;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Optional;

@Service
@RestController
public class AccountController {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.issuer}")
    private String jwtIssuer;


    @Value("${security.jwt.time}")
    private String Jwttime;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    private String createJwtToken(Employee employee) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(jwtIssuer)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(Long.parseLong(Jwttime)))
                .subject(employee.getEmail())
                .claim("role", employee.getRole_id())
                .build();

        var encoder = new NimbusJwtEncoder(
                new ImmutableSecret<>(secretKey.getBytes()));
        var params = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return encoder.encode(params).getTokenValue();
    }

    @PostMapping("cms-valid/login")
    public ResponseEntity<Object> login(
            @Valid @RequestBody LoginDTO logindto,
            BindingResult result) {
        if (result.hasErrors()) {
            var errorsList = result.getAllErrors();
            var errorsMap = new HashMap<String, String>();

            for (var error : errorsList) {
                var fieldError = (FieldError) error;
                errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorsMap);
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            logindto.getEmail(),
                            logindto.getPassword()
                    )
            );

            Optional<Employee> optionalEmployee = employeeRepo.findEmployeeByEmail(logindto.getEmail());

            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                String jwtToken = createJwtToken(employee);

                var response = new HashMap<String, Object>();
                response.put("token", jwtToken);
                response.put("employee", employee);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Employee not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Bad username or password");
        }
    }

    @PostMapping("/cms-valid/logout")
    public ResponseEntity<Object> logout() {
        return ResponseEntity.ok().body("Successfully logged out");
    }


}
