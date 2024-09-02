package api_validvisi.API.Model.AdminVisi;

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
    private String id;

    @Column(name = "category_event_id")
    @Getter
    @Setter
    private String categoryEventId;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column(name = "lower_title")
    @Getter
    @Setter
    private String lowerTitle;

    @Column
    @Getter
    @Setter
    private String desc;

    @Column
    @Getter
    @Setter
    private String place;

    @Column
    @Getter
    @Setter
    private String source;

    @Column(name = "meta_keywords")
    @Getter
    @Setter
    private String metaKeywords;

    @Column
    @Getter
    @Setter
    private String photo;

    @Column(name = "created_by")
    @Getter
    @Setter
    private String createdBy;

    @Column(name = "updated_by")
    @Getter
    @Setter
    private String updatedBy;

    @Column(name = "registration_date")
    @Getter
    @Setter
    private LocalDateTime registrationDate;

    @Column(name = "created_at")
    @Getter
    @Setter
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updatedAt;

    @Column
    @Getter
    @Setter
    private String status;
}
