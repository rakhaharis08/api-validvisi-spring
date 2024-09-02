package api_validvisi.API.Model.CMSValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "guest_users")
public class GuestUsers {

    @Id
    @Getter
    @Setter
    private long id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String position;

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
    private int Status;
}
