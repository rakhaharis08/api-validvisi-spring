package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "faqs")
public class Faq {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "page_id")
    @Getter
    @Setter
    private String pageId;

    @Column(name = "language_id")
    @Getter
    @Setter
    private String languageId;

    @Column
    @Getter
    @Setter
    private String question;

    @Column
    @Getter
    @Setter
    private String answer;

    @Column
    @Getter
    @Setter
    private String status;

    @Column(name = "created_by")
    @Getter
    @Setter
    private String createdBy;

    @Column(name = "updated_by")
    @Getter
    @Setter
    private String updatedBy;

    @Column(name = "created_at")
    @Getter
    @Setter
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updatedAt;
}
