package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Getter
    @Setter
    private long id;

    @Column
    @Getter
    @Setter
    private String fullname;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String role_id;

    @Column
    @Getter
    @Setter
    private String position_id;

    @Column
    @Getter
    @Setter
    private String desk_id;

    @Column
    @Getter
    @Setter
    private String sub_desk_id;

    @Column
    @Getter
    @Setter
    private String no_hp;

    @Column
    @Getter
    @Setter
    private Integer gender;

    @Column
    @Getter
    @Setter
    private String date_of_birth;

    @Column
    @Getter
    @Setter
    private String place_of_birth;

    @Column
    @Getter
    @Setter
    private String address;

    @Column
    @Getter
    @Setter
    private String imaage;

    @Column
    @Getter
    @Setter
    private String remember_token;

    @Column
    @Getter
    @Setter
    private Integer status;

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
    private String theme;


}
