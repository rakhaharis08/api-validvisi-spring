package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "page")
public class Page {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "page_type_id")
    @Getter
    @Setter
    private String pageTypeId;

    @Column(name = "sub_page_type_id")
    @Getter
    @Setter
    private String subPageTypeId;

    @Column(name = "footer_page_type_id")
    @Getter
    @Setter
    private String footerPageTypeId;

    @Column
    @Getter
    @Setter
    private String title;

    @Column(name = "lower_title")
    @Getter
    @Setter
    private String lowerTitle;

    @Column
    @Getter
    @Setter
    private String desc;

    @Column(name = "value_1")
    @Getter
    @Setter
    private String value1;

    @Column(name = "value_2")
    @Getter
    @Setter
    private String value2;

    @Column(name = "value_3")
    @Getter
    @Setter
    private String value3;

    @Column(name = "value_4")
    @Getter
    @Setter
    private String value4;

    @Column(name = "value_5")
    @Getter
    @Setter
    private String value5;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column(name = "meta_title")
    @Getter
    @Setter
    private String metaTitle;

    @Column(name = "meta_description")
    @Getter
    @Setter
    private String metaDescription;

    @Column(name = "meta_keywords")
    @Getter
    @Setter
    private String metaKeywords;

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

    @Column
    @Getter
    @Setter
    private String status;
}
