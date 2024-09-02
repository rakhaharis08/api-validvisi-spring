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
@Table(name = "billing_detail")
public class BillingDetail {

    @Id
    @Getter
    @Setter
    private String id;

    @Column
    @Getter
    @Setter
    private String billing_id;

    @Column
    @Getter
    @Setter
    private String product_id;

    @Column
    @Getter
    @Setter
    private String product_type;

    @Column
    @Getter
    @Setter
    private String voucher_id;

    @Column
    @Getter
    @Setter
    private String qty;

    @Column
    @Getter
    @Setter
    private Double trx_value;

    @Column
    @Getter
    @Setter
    private String discount;

    @Column
    @Getter
    @Setter
    private Double trx_total;

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
