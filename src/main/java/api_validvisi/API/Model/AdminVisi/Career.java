package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "career")
public class Career {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "department_id")
    @Getter
    @Setter
    private String department_id;

    @Column(name = "career_type_id")
    @Getter
    @Setter
    private String career_type_id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column(name = "desc")
    @Getter
    @Setter
    private String desc;

    @Column
    @Getter
    @Setter
    private String requirements;

    @Column
    @Getter
    @Setter
    private String experience;

    @Column(name = "meta_keywords")
    @Getter
    @Setter
    private String meta_keywords;

    @Column(name = "created_by")
    @Getter
    @Setter
    private String created_by;

    @Column(name = "updated_by")
    @Getter
    @Setter
    private String updated_by;

    @Column(name = "created_at")
    @Getter
    @Setter
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updated_at;

    @Column
    @Getter
    @Setter
    private String status;
}
