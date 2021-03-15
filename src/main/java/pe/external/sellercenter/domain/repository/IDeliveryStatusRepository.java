package pe.external.sellercenter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.external.sellercenter.domain.entity.DeliveryStateEntity;

public interface IDeliveryStatusRepository extends JpaRepository<DeliveryStateEntity, Long> {
}

