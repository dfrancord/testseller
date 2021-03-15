package pe.external.sellercenter.services.adapters;
import org.springframework.stereotype.Component;
import pe.external.sellercenter.domain.entity.DeliveryEvidenceEntity;
import pe.external.sellercenter.domain.entity.DeliveryStateEntity;
import pe.external.sellercenter.domain.model.DeliveryEvidenceDTO;

@Component
public class DeliveryEvidenceAdapter {
    
    public DeliveryEvidenceEntity fromDTO(DeliveryEvidenceDTO data,DeliveryStateEntity dataState) {
        final var ret = new DeliveryEvidenceEntity();

        ret.setDeliveryState(dataState);
        ret.setEvidenceUrl(data.getEvidenceurl());



        return ret;
    }

    public DeliveryEvidenceDTO fromEntity(DeliveryEvidenceEntity data) {
        final var ret = new DeliveryEvidenceDTO();

        ret.setEvidenceurl(data.getEvidenceUrl());
        


        return ret;
    }
}
