package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.Employee;
import api_validvisi.API.Projection.CMSValid.RedakturProjection;
import api_validvisi.API.Projection.CMSValid.ReporterProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(int id);
    Optional<Employee> findEmployeeByEmail(String email);
    Optional<Employee> findEmployeeByFullname(String fullname);

    @Query("SELECT e FROM Employee e WHERE (e.role_id = :role1 OR e.role_id = :role2) AND e.status != :status")
    List<Employee> findEmployeesByRoleAndStatus(
            @Param("role1") String role1,
            @Param("role2") String role2,
            @Param("status") Integer status
    );

    @Query("SELECT e.id AS id, e.fullname AS fullname FROM Employee e WHERE (e.role_id = :role1 OR e.role_id = :role2) AND e.status != :status")
    List<RedakturProjection> findRedakturSummariesByRoleAndStatus(
            @Param("role1") String role1,
            @Param("role2") String role2,
            @Param("status") Integer status
    );

    @Query("SELECT e.id AS id, e.fullname AS fullname FROM Employee e WHERE e.role_id = :role1 AND e.status != :status")
    List<ReporterProjection> findReporterSummariesByRoleAndStatus(
            @Param("role1") String role1,
            @Param("status") Integer status
    );
}
