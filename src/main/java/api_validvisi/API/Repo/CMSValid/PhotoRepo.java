package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PhotoRepo extends JpaRepository<Photo, Long>, JpaSpecificationExecutor<Photo> {
    Optional<Photo> findPhotoById(int id);
    Page<Photo> findAll(Pageable pageable);
}
