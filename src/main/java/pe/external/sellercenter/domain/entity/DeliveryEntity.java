package pe.external.sellercenter.domain.entity;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_delivery")
public class DeliveryEntity {
  

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "delivery_id", nullable = false)
    private Long DeliveryId;


    @Column(name = "account_id")
    private int Accountid;

    @Column(name = "account_name", nullable = false)
    private String AccountName;

    @Column(name = "order_id")
    private String OrderId;

   
    @Column(name = "seller_id")
    private int SellerId ;

  
    @Column(name = "seller_name")
    private String SellerName;

 
    @Column(name = "gruide_number")
    private String GuideNumber;


    @Column(name = "tracking_url")
    private String TrackingUrl;

 
    @Column(name = "download_date ")
    private LocalDateTime DownloadDate ;

    
}
