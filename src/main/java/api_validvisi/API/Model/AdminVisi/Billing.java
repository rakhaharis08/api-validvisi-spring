package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String user_id;

    @Column
    @Getter
    @Setter
    private String nomor;

    @Column
    @Getter
    @Setter
    private String desc;

    @Column
    @Getter
    @Setter
    private String discount;

    @Column
    @Getter
    @Setter
    private String trx_date;

    @Column
    @Getter
    @Setter
    private String trx_value;


    @Column
    @Getter
    @Setter
    private String trx_total;

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
