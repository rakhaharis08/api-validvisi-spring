package api_validvisi.API.Repo.CMSValid;

import api_validvisi.API.Model.CMSValid.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface NewsRepo extends JpaRepository<News, Long>, JpaSpecificationExecutor<News> {
    Optional<News> findNewsById(int id);
    Page<News> findAll(Pageable pageable);
}
