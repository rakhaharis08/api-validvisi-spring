package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.ParamValid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParamValidRepo extends JpaRepository<ParamValid, Long> {
    Optional<ParamValid> findParamById(int id);
}
