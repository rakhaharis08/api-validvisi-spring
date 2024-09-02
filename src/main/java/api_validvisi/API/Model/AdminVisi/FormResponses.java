package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "form_responses")
public class FormResponses {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String responden_id;

    @Column
    @Getter
    @Setter
    private String form_id;

    @Column
    @Getter
    @Setter
    private String form_field_id;

    @Column
    @Getter
    @Setter
    private String response_code;

    @Column
    @Getter
    @Setter
    private String respondent_ip;

    @Column
    @Getter
    @Setter
    private String respondent_user_agent;

    @Column
    @Getter
    @Setter
    private String latitude;

    @Column
    @Getter
    @Setter
    private String longitude;

    @Column
    @Getter
    @Setter
    private LocalDateTime deleted_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime created_at;

    @Column
    @Getter
    @Setter
    private LocalDateTime updated_at;
}
