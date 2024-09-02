package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class News {

    @Id
    @Setter
    @Getter
    private long id;

    @Column(length = 255)
    @Getter
    @Setter
    private String title;

    @Column(length = 255)
    @Getter
    @Setter
    private String lower_title;

    @Column
    @Getter
    @Setter
    private Integer theme_id;

    @Column
    @Getter
    @Setter
    private Integer desk_id;

    @Column
    @Getter
    @Setter
    private Integer canal_id;

    @Column
    @Getter
    @Setter
    private Integer sub_canal_id;

    @Column
    @Getter
    @Setter
    private Integer category_id;

    @Column(name = "`select`")
    @Getter
    @Setter
    private Integer select;

    @Column
    @Getter
    @Setter
    private Integer reporter;

    @Column
    @Getter
    @Setter
    private Integer outside_reporter;

    @Column
    @Getter
    @Setter
    private Integer placement_id;

    @Column(length = 255)
    @Getter
    @Setter
    private String headline;

    @Column
    @Getter
    @Setter
    private Integer selected;

    @Column(length = 255)
    @Getter
    @Setter
    private String content;

    @Column(length = 255)
    @Getter
    @Setter
    private String x_iframe;

    @Column(length = 255)
    @Getter
    @Setter
    private String x_lower_content;

    @Column(length = 255)
    @Getter
    @Setter
    private String main_photo;

    @Column(length = 255)
    @Getter
    @Setter
    private String thumbnail;

    @Column(length = 255)
    @Getter
    @Setter
    private String caption_photo;

    @Column(length = 255)
    @Getter
    @Setter
    private String slug;

    @Column(length = 255)
    @Getter
    @Setter
    private String hastag;

    @Column(length = 255)
    @Getter
    @Setter
    private String seo;

    @Column(length = 255)
    @Getter
    @Setter
    private String keyword;

    @Column
    @Getter
    @Setter
    private Integer add_id;

    @Column
    @Getter
    @Setter
    private Integer edit_id;

    @Column
    @Getter
    @Setter
    private Integer interviewees_id;

    @Column
    @Getter
    @Setter
    private Integer institution_id;

    @Column
    @Getter
    @Setter
    private Integer position_id;

    @Column(name = "`status`")
    @Getter
    @Setter
    private Integer Status;

    @Column
    @Getter
    @Setter
    private LocalDateTime publish_date;

    @Column
    @Getter
    @Setter
    private LocalDateTime updated_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime created_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime deleted_at;

    @Column
    @Getter
    @Setter
    private Integer views;

    @Column
    @Getter
    @Setter
    private LocalDateTime date;

    @Column
    @Getter
    @Setter
    private Integer editor_id;

    @Column
    @Getter
    @Setter
    private Integer editor_status;

    @Column(length = 255)
    @Getter
    @Setter
    private String hashtag;
}
