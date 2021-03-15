package pe.external.sellercenter.services.adapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.external.sellercenter.domain.entity.DeliveryStateEntity;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class DeliveryStateAdapter {

    @Autowired DeliveryEvidenceAdapter childAdapter;

    public DeliveryStateEntity fromDTO(DeliveryStatusDTO data) {
        final var ret = new DeliveryStateEntity();

        ret.setDescription(data.getStatusDescription());
        ret.setSellerName(data.getSellername());
        ret.setGuideNumber(data.getGuidenumber());
        ret.setTrackingUrl(data.getTrackingurl());
        ret.setAccountName(data.getAccount());
        ret.setOrderId(data.getOrdernumber());
        ret.setState(data.getStatus());
        LocalDateTime date = LocalDateTime.now();
        ret.setDownloadDate(date);

        return ret;
    }

    public DeliveryStatusDTO fromEntity(DeliveryStateEntity data) {
        final var ret = new DeliveryStatusDTO();

        ret.setStatusDescription(data.getDescription());
        ret.setSellername(data.getSellerName());
        ret.setGuidenumber(data.getGuideNumber());
        ret.setTrackingurl(data.getTrackingUrl());
        ret.setAccount(data.getAccountName());
        ret.setOrdernumber(data.getOrderId());
        ret.setStatus(data.getState());

        if (data.getEvidence() == null) {
            data.setEvidence(new ArrayList<>());
        }
        final var evidences = data.getEvidence()
                .stream()
                .map(i -> childAdapter.fromEntity(i))
                .collect(Collectors.toList());

        ret.setEvidences(evidences);

        return ret;
    }
    
}
