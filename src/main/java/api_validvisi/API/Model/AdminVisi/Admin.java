package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String department_id;

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
    private String email_token;

    @Column
    @Getter
    @Setter
    private LocalDateTime email_verified_at;

    @Column
    @Getter
    @Setter
    private String password;

    @Column
    @Getter
    @Setter
    private String remember_token;

    @Column
    @Getter
    @Setter
    private String no_hp;

    @Column
    @Getter
    @Setter
    private String gender;

    @Column
    @Getter
    @Setter
    private LocalDateTime dob;

    @Column
    @Getter
    @Setter
    private String pob;

    @Column
    @Getter
    @Setter
    private String country;

    @Column
    @Getter
    @Setter
    private String province;

    @Column
    @Getter
    @Setter
    private String city;

    @Column
    @Getter
    @Setter
    private String address;

    @Column
    @Getter
    @Setter
    private String zip_code;

    @Column
    @Getter
    @Setter
    private String photo;

    @Column
    @Getter
    @Setter
    private String show_in_portal;

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
    private LocalDateTime deleted_at;

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
    private String status;
}
