package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "form_fields")
public class FormFields {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String form_id;

    @Column
    @Getter
    @Setter
    private String form_section_id;

    @Column
    @Getter
    @Setter
    private int sequence;

    @Column
    @Getter
    @Setter
    private String template;

    @Column
    @Getter
    @Setter
    private String attribute;

    @Column
    @Getter
    @Setter
    private String question;

    @Column
    @Getter
    @Setter
    private String input;

    @Column
    @Getter
    @Setter
    private boolean required;

    @Column
    @Getter
    @Setter
    private String options;

    @Column
    @Getter
    @Setter
    private String filled;

    @Column
    @Getter
    @Setter
    private String image;

    @Column
    @Getter
    @Setter
    private String jump;

    @Column
    @Getter
    @Setter
    private String map;

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
