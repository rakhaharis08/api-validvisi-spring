package api_validvisi.API.Spesification.CMSValid;


import api_validvisi.API.Model.CMSValid.Video;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VideoSpecification {
    public static Specification<Video> filterVideo(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer canalId,
            String title) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (startDate != null && endDate != null) {
                predicates.add(criteriaBuilder.between(root.get("publish_date"), startDate, endDate));
            }

            if (canalId != null) {
                predicates.add(criteriaBuilder.equal(root.get("canal_id"), canalId));
            }

            if (title != null && !title.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
