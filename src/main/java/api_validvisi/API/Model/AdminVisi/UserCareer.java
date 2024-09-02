package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_career")
public class UserCareer {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "fullname")
    @Getter
    @Setter
    private String fullname;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "no_hp")
    @Getter
    @Setter
    private String no_hp;

    @Column(name = "portfolio")
    @Getter
    @Setter
    private String portfolio;

    @Column(name = "url_portfolio")
    @Getter
    @Setter
    private String url_portfolio;

    @Column(name = "resume")
    @Getter
    @Setter
    private String resume;

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

    @Column(name = "status")
    @Getter
    @Setter
    private String status;
}
