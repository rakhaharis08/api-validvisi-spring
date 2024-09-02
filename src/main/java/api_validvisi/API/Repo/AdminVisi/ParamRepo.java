package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParamRepo extends JpaRepository<Param, String> {
    Optional<Param> findParamById(String id);
}
