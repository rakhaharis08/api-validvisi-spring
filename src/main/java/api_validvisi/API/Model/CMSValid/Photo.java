package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "photo")
public class Photo {

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
    private String keyword;

    @Column
    @Getter
    @Setter
    private String image;

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
    private Integer canal_id;

    @Column
    @Getter
    @Setter
    private String category_id;

    @Column
    @Getter
    @Setter
    private String employee_id;

    @Column
    @Getter
    @Setter
    private String source;

    @Column
    @Getter
    @Setter
    private String status;

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
    private LocalDateTime deleted_at;

    @Column
    @Getter
    @Setter
    private Integer sub_canal_id;

    @Column
    @Getter
    @Setter
    private Integer selected;
}
