package api_validvisi.API.Repo.CMSValid;


import api_validvisi.API.Model.CMSValid.CanalValid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CanalValidRepo extends JpaRepository<CanalValid, Long> {
    Optional<CanalValid> findCanalById(int id);
}
