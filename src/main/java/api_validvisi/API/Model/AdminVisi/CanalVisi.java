package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "canal")
public class CanalVisi {

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
    private String desc;

    @Column
    @Getter
    @Setter
    private String parent;

    @Column
    @Getter
    @Setter
    private Integer level;

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
