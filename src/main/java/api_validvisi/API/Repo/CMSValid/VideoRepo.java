package api_validvisi.API.Repo.CMSValid;


import api_validvisi.API.Model.CMSValid.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface VideoRepo extends JpaRepository<Video, Long>, JpaSpecificationExecutor<Video> {
    Optional<Video> findVideoById(int id);
    Page<Video> findAll(Pageable pageable);
}
