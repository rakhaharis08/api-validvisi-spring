package api_validvisi.API.Repo.AdminVisi;

import api_validvisi.API.Model.AdminVisi.ParamDetailVisi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParamDetailVisiRepo extends JpaRepository<ParamDetailVisi, String> {

    Optional<ParamDetailVisi> findById(String id);
    List<ParamDetailVisi> findByParamId(String paramId);

}
