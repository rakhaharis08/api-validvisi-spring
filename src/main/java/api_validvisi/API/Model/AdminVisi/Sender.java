package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "senders")
public class Sender {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String type;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String description;

    @Column
    @Getter
    @Setter
    private String phone;

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
