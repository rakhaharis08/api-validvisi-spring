package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @Getter
    @Setter
    private long id;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String description;

    @Column
    @Getter
    @Setter
    private String iframe;

    @Column
    @Getter
    @Setter
    private String thumbnail;

    @Column
    @Getter
    @Setter
    private String keyword;

    @Column
    @Getter
    @Setter
    private String employee_id;

    @Column
    @Getter
    @Setter
    private String selected_id;

    @Column
    @Getter
    @Setter
    private String canal_id;

    @Column
    @Getter
    @Setter
    private Integer sub_canal_id;

    @Column
    @Getter
    @Setter
    private Integer Status;

    @Column
    @Getter
    @Setter
    private LocalDateTime createad_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime updated_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime deleted_at;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private Date publish_date;

    @Column
    @Getter
    @Setter
    private Integer selected;

    @Column
    @Getter
    @Setter
    private Integer category_id;
}
