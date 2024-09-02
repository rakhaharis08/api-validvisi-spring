package api_validvisi.API.Spesification.CMSValid;

import api_validvisi.API.Model.CMSValid.News;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsSpecification {

    public static Specification<News> filterNews(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer canalId,
            Integer subCanalId,
            Integer placementId,
            String title) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (startDate != null && endDate != null) {
                predicates.add(criteriaBuilder.between(root.get("publish_date"), startDate, endDate));
            }

            if (canalId != null) {
                predicates.add(criteriaBuilder.equal(root.get("canal_id"), canalId));
            }

            if (subCanalId != null) {
                predicates.add(criteriaBuilder.equal(root.get("sub_canal_id"), subCanalId));
            }

            if (placementId != null) {
                predicates.add(criteriaBuilder.equal(root.get("placement_id"), placementId));
            }

            if (title != null && !title.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
