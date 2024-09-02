package api_validvisi.API.Model.AdminVisi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "broadcast")
public class Broadcast {

    @Id
    @Getter
    @Setter
    private String id;

    @Column(name = "channel_id")
    @Getter
    @Setter
    private String channelId;

    @Column(name = "page_id")
    @Getter
    @Setter
    private String pageId;

    @Column(name = "sub_page_id")
    @Getter
    @Setter
    private String subPageId;

    @Column
    @Getter
    @Setter
    private String title;

    @Column(name = "desc")
    @Getter
    @Setter
    private String desc;

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

    @Column
    @Getter
    @Setter
    private String status;
}
