package pe.external.sellercenter.services.adapters;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import pe.external.sellercenter.domain.entity.DeliveryEntity;
import pe.external.sellercenter.domain.model.DeliveryDTO;


@Component
public class DeliveryAdapter {
    

      public DeliveryEntity fromDTO(DeliveryDTO data) {
        final var ret = new DeliveryEntity();

        ret.setOrderId(data.getOrderNumber());
        ret.setSellerName(data.getSellerName());
        ret.setGuideNumber(data.getGuideNumber());
        ret.setTrackingUrl(data.getTrackingUrl());
        ret.setAccountName(data.getAccount());
        LocalDateTime date = LocalDateTime.now();
        ret.setDownloadDate(date);
        return ret;
    }

    public DeliveryDTO fromEntity(DeliveryEntity data) {
      final var ret = new DeliveryDTO();

      ret.setOrderNumber(data.getOrderId());
      ret.setSellerName(data.getSellerName());
      ret.setGuideNumber(data.getGuideNumber());
      ret.setTrackingUrl(data.getTrackingUrl());
      ret.setAccount(data.getAccountName());
      ret.setId(data.getDeliveryId());

      return ret;
  }
}
