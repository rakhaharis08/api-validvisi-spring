package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.SubCanal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCanalRepo extends JpaRepository<SubCanal, Long> {
    Optional<SubCanal> findSubCanalById(int id);
    List<SubCanal> findSubCanalByName(String name);
}
