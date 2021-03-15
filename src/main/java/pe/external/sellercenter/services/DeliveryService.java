package pe.external.sellercenter.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.external.sellercenter.domain.entity.DeliveryEntity;
import pe.external.sellercenter.domain.model.DeliveryDTO;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;
import pe.external.sellercenter.domain.repository.IDeliveryRepository;
import pe.external.sellercenter.domain.repository.IDeliveryStatusRepository;
import pe.external.sellercenter.domain.service.IDeliveryService;
import pe.external.sellercenter.services.adapters.DeliveryAdapter;
import pe.external.sellercenter.services.adapters.DeliveryEvidenceAdapter;
import pe.external.sellercenter.services.adapters.DeliveryStateAdapter;

import java.util.stream.Collectors;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired DeliveryAdapter DeliveryAdapter;
    @Autowired DeliveryEvidenceAdapter DeliveryEvidenceAdapter;
    @Autowired DeliveryStateAdapter DeliveryStateAdapter;
    @Autowired IDeliveryStatusRepository DeliveryStatusRepository;
    @Autowired IDeliveryRepository DeliveryRepository;

    @Override
    @Transactional
    public DeliveryDTO createOrUpdate(DeliveryDTO data) {
    
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setAccountName(data.getAccount());
        deliveryEntity.setGuideNumber(data.getGuideNumber());
        deliveryEntity.setOrderId(data.getOrderNumber());
        deliveryEntity.setSellerName(data.getSellerName());

        Example<DeliveryEntity> deliveryEntityExample = Example.of(deliveryEntity);
        
      final  var deliveryFind= DeliveryRepository.findOne(deliveryEntityExample);
      
      var delivery = deliveryFind.orElse(null);

      if (deliveryFind.isEmpty()) {
         delivery=DeliveryAdapter.fromDTO(data);
        DeliveryRepository.save(delivery);
      }
        

       var entity=delivery;

        return DeliveryAdapter.fromEntity(entity);
    }

    @Override
    public DeliveryStatusDTO createOrUpdateStatus(DeliveryStatusDTO data) {
        
        final var delivery=DeliveryStateAdapter.fromDTO(data);

        DeliveryStatusRepository.save(delivery);

       

        final var evidences = data.getEvidences()
        .stream()
        .map(i -> DeliveryEvidenceAdapter.fromDTO(i, delivery))
        .collect(Collectors.toList());

        delivery.getEvidence().addAll(evidences);

        DeliveryStatusRepository.save(delivery);

        return DeliveryStateAdapter.fromEntity(delivery);
    }
    

}
