package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "position_id")
    @Getter
    @Setter
    private String position_id;

    @Column(name = "banner_type_id")
    @Getter
    @Setter
    private String banner_type_id;

    @Column(name = "device_id")
    @Getter
    @Setter
    private String device_id;

    @Column
    @Getter
    @Setter
    private Integer sequence;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String desc;

    @Column
    @Getter
    @Setter
    private String thumbnail;

    @Column
    @Getter
    @Setter
    private String source;

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
