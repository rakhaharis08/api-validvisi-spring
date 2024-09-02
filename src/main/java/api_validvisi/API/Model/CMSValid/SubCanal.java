package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "sub_canal")
public class SubCanal {

    @Id
    @Setter
    @Getter
    private long id;

    @Column
    @Setter
    @Getter
    private String name;

    @Column
    @Setter
    @Getter
    private Integer canal_id;

    @Column
    @Setter
    @Getter
    private Integer parent;

    @Column
    @Setter
    @Getter
    private String slug;

    @Column
    @Setter
    @Getter
    private Integer employee_id;

    @Column
    @Setter
    @Getter
    private Integer status;

    @Column
    @Setter
    @Getter
    private LocalDateTime created_at;


    @Column
    @Setter
    @Getter
    private LocalDateTime updated_at;

    @Column
    @Setter
    @Getter
    private LocalDateTime deleted_at;
}
