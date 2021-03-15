package pe.external.sellercenter.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.external.sellercenter.domain.entity.DeliveryEntity;

public interface IDeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
}
