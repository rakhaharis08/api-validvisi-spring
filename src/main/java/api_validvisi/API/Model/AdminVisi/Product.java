package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Getter
    private String id;

    @Column
    @Getter
    @Setter
    private String product_type_id;

    @Column
    @Getter
    @Setter
    private String category_id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String slug;

    @Column
    @Getter
    @Setter
    private String desc;

    @Column
    @Getter
    @Setter
    private LocalDateTime release_date;

    @Column
    @Getter
    @Setter
    private String writer;

    @Column
    @Getter
    @Setter
    private String editor;

    @Column
    @Getter
    @Setter
    private String original_price;

    @Column
    @Getter
    @Setter
    private String discount;

    @Column
    @Getter
    @Setter
    private String price;

    @Column
    @Getter
    @Setter
    private String meta_keywords;

    @Column
    @Getter
    @Setter
    private String photo;

    @Column
    @Getter
    @Setter
    private String file;

    @Column
    @Getter
    @Setter
    private String trial;

    @Column
    @Getter
    @Setter
    private String pages;

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
    private LocalDateTime publish_date;

    @Column
    @Getter
    @Setter
    private LocalDateTime expired_date;

    @Column
    @Getter
    @Setter
    private String count_buy;

    @Column
    @Getter
    @Setter
    private String count_review;

    @Column
    @Getter
    @Setter
    private String is_recomend;

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
