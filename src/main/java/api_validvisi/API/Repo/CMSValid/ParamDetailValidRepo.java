package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.ParamDetailValid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParamDetailValidRepo extends JpaRepository<ParamDetailValid, Long> {
    Optional<ParamDetailValid> findParamDetailById(long id);

    @Query("SELECT p FROM ParamDetailValid p WHERE p.param_id = :param_id")
    List<ParamDetailValid> findByParamId(int param_id);

}
