package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String description;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private String meta_title;

    @Column
    @Getter
    @Setter
    private String meta_description;

    @Column
    @Getter
    @Setter
    private String meta_keywords;

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
