package pe.external.sellercenter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.external.sellercenter.domain.entity.DeliveryOrderEntity;

public interface IDeliveryOrderRepository extends JpaRepository<DeliveryOrderEntity, Long> {
}
