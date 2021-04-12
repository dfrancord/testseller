package pe.external.sellercenter.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import pe.external.sellercenter.domain.model.DeliberyOrderDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_delivery_order_seller")
@TypeDef(typeClass = JsonBinaryType.class, defaultForType = DeliberyOrderDTO.class)
public class DeliveryOrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sellername")
    private String sellerName;

    @Column(name = "orderid")
    private String Orderid;

    @Column(columnDefinition = "json", name = "dataorder")
    private DeliberyOrderDTO json;
}
