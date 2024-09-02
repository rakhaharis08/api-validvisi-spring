package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "document_type_id")
    @Getter
    @Setter
    private String document_type_id;

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
    private String file;

    @Column
    @Getter
    @Setter
    private String thumbnail;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private String source;

    @Column
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
