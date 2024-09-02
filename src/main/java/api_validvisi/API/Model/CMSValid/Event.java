package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {

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
    private String device_type;

    @Column
    @Getter
    @Setter
    private int type;

    @Column
    @Getter
    @Setter
    private String image;

    @Column
    @Getter
    @Setter
    private LocalDateTime date;

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
    private String seo;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private int employee_id;

    @Column
    @Getter
    @Setter
    private LocalDateTime start_date;

    @Column
    @Getter
    @Setter
    private LocalDateTime end_date;

    @Column
    @Getter
    @Setter
    private int status;

    @Column
    @Getter
    @Setter
    private String url;


}
