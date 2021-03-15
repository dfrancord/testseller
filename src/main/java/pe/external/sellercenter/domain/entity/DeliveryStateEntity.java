package pe.external.sellercenter.domain.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_delivery_state")
public class DeliveryStateEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "delivery_state_id", nullable = false)
    private Long DeliveryStateId;

    @Column(name = "account_id", nullable = false)
    private int AccountId;
    @Column(name = "account_name", nullable = false)
    private String AccountName;

    @Column(name = "order_id", nullable = false)
    private String OrderId;

    @Column(name = "seller_name")
    private String SellerName;
    
    @Column(name = "gruide_number", nullable = false)
    private String GuideNumber;

    @Column(name = "tracking_url", nullable = false)
    private String TrackingUrl;

    @Column(name = "state", nullable = false)
    private String State;

    @Column(name = "description", nullable = false)
    private String Description;

    @Column(name = "download_date ", nullable = false)
    private LocalDateTime DownloadDate ;

    @OneToMany(mappedBy = "DeliveryState", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryEvidenceEntity> Evidence = new ArrayList<>();

}
