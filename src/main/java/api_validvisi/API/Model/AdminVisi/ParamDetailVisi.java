package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "param_detail")
public class ParamDetailVisi {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "param_id")
    @Getter
    @Setter
    private String paramId;

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
    private String value_1;

    @Column
    @Getter
    @Setter
    private String value_2;

    @Column
    @Getter
    @Setter
    private String value_3;

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
