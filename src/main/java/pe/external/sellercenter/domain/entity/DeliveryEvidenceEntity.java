package pe.external.sellercenter.domain.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_delivery_evidence")
public class DeliveryEvidenceEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "Delivery_Evidence_Id", nullable = false)
    private Long DeliveryEvidenceId;

    @Column(name = "evidence_url")
    private String EvidenceUrl;

    @Column(name = "download_date")
    private LocalDateTime DownloadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_state_id", referencedColumnName = "delivery_state_id", nullable = false)
    private DeliveryStateEntity DeliveryState;
}
