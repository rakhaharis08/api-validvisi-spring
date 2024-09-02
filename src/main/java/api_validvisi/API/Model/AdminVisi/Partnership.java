package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "partnerships")
public class Partnership {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "fullname")
    @Getter
    @Setter
    private String fullname;

    @Column(name = "company_name")
    @Getter
    @Setter
    private String companyName;

    @Column(name = "company_email")
    @Getter
    @Setter
    private String companyEmail;

    @Column(name = "no_hp")
    @Getter
    @Setter
    private String noHp;

    @Column
    @Getter
    @Setter
    private String website;

    @Column
    @Getter
    @Setter
    private String address;

    @Column
    @Getter
    @Setter
    private String content;

    @Column
    @Getter
    @Setter
    private String status;

    @Column
    @Getter
    @Setter
    private String photo;

    @Column(name = "show_in_portal")
    @Getter
    @Setter
    private Boolean showInPortal;

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
