package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "media_monitor")
public class MediaMonitor {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String client_id;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private LocalDateTime date;

    @Column
    @Getter
    @Setter
    private String media_name;

    @Column(name = "media_type")
    @Getter
    @Setter
    private String mediaType;


    @Column
    @Getter
    @Setter
    private String page;

    @Column
    @Getter
    @Setter
    private String scope;

    @Column
    @Getter
    @Setter
    private String media_region;

    @Column
    @Getter
    @Setter
    private String sentiment;

    @Column
    @Getter
    @Setter
    private String reporter;

    @Column
    @Getter
    @Setter
    private String newstrends;

    @Column
    @Getter
    @Setter
    private String content;

    @Column
    @Getter
    @Setter
    private String platform;

    @Column
    @Getter
    @Setter
    private String users;

    @Column
    @Getter
    @Setter
    private Integer likes;

    @Column
    @Getter
    @Setter
    private Integer comment;

    @Column
    @Getter
    @Setter
    private Integer share;

    @Column
    @Getter
    @Setter
    private Integer followers;

    @Column
    @Getter
    @Setter
    private String status;

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
}
