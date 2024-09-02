package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @Getter
    private String id;

    @Column
    @Getter
    @Setter
    private String theme_id;

    @Column
    @Getter
    @Setter
    private String canal_id;

    @Column
    @Getter
    @Setter
    private String rubric_id;

    @Column
    @Getter
    @Setter
    private String placement_id;

    @Column
    @Getter
    @Setter
    private String reporter_id;

    @Column
    @Getter
    @Setter
    private String visitor_id;

    @Column
    @Getter
    @Setter
    private String language_id;

    @Column
    @Getter
    @Setter
    private String parent ;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String lower_title;

    @Column
    @Getter
    @Setter
    private String content;

    @Column
    @Getter
    @Setter
    private String caption_photo;

    @Column
    @Getter
    @Setter
    private String main_photo;

    @Column
    @Getter
    @Setter
    private String thumbnail;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private String keyword;

    @Column
    @Getter
    @Setter
    private LocalDateTime publish_date;

    @Column
    @Getter
    @Setter
    private String is_recomend;

    @Column
    @Getter
    @Setter
    private String count_read;

    @Column
    @Getter
    @Setter
    private String created_by;

    @Column
    @Getter
    @Setter
    private String updated_by;

    @Column
    @Getter
    @Setter
    private LocalDateTime created_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime updated_at;

    @Column
    @Getter
    @Setter
    private String status;
}
