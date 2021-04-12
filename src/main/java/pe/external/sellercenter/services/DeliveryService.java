package pe.external.sellercenter.services;
import com.kenai.jffi.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.external.sellercenter.domain.entity.DeliveryEntity;
import pe.external.sellercenter.domain.entity.DeliveryOrderEntity;
import pe.external.sellercenter.domain.entity.DeliveryStateEntity;
import pe.external.sellercenter.domain.model.DeliberyOrderDTO;
import pe.external.sellercenter.domain.model.DeliveryDTO;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;
import pe.external.sellercenter.domain.repository.IDeliveryOrderRepository;
import pe.external.sellercenter.domain.repository.IDeliveryRepository;
import pe.external.sellercenter.domain.repository.IDeliveryStatusRepository;
import pe.external.sellercenter.domain.service.IDeliveryService;
import pe.external.sellercenter.services.adapters.DeliveryAdapter;
import pe.external.sellercenter.services.adapters.DeliveryEvidenceAdapter;
import pe.external.sellercenter.services.adapters.DeliveryStateAdapter;
import org.springframework.data.domain.ExampleMatcher;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired DeliveryAdapter DeliveryAdapter;
    @Autowired DeliveryEvidenceAdapter DeliveryEvidenceAdapter;
    @Autowired DeliveryStateAdapter DeliveryStateAdapter;
    @Autowired IDeliveryStatusRepository DeliveryStatusRepository;
    @Autowired IDeliveryRepository DeliveryRepository;
    @Autowired IDeliveryOrderRepository DeliveryOrderRepository;

    @Override
    public List<DeliberyOrderDTO> GetOrderSeller(String Seller)
    {

        DeliveryOrderEntity deliveryOrderEntity=new DeliveryOrderEntity();
        deliveryOrderEntity.setSellerName(Seller);
        Example<DeliveryOrderEntity> deliveryEntityExample = Example.of(deliveryOrderEntity, ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnorePaths("Id")
                .withIgnorePaths("Orderid")
                .withIgnorePaths("json")
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT));
       

        final  var deliveryFind= DeliveryOrderRepository.findAll(deliveryEntityExample);
        List<DeliveryOrderEntity> deliveryOrders = deliveryFind;
        List<DeliberyOrderDTO> deliberyOrderDTOList=new ArrayList<DeliberyOrderDTO>();

        if(deliveryOrders == null){
            return deliberyOrderDTOList;
        }


        for (DeliveryOrderEntity deliveryOrder: deliveryOrders) {
            deliberyOrderDTOList.add(deliveryOrder.getJson());
        }

        return deliberyOrderDTOList;
    }

    @java.lang.Override
    public List<DeliberyOrderDTO> GetOrderSeller(String Seller, String Orderid) {
        DeliveryOrderEntity deliveryOrderEntity=new DeliveryOrderEntity();
        deliveryOrderEntity.setSellerName(Seller);
        deliveryOrderEntity.setOrderid(Orderid);
        Example<DeliveryOrderEntity> deliveryEntityExample = Example.of(deliveryOrderEntity, ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnorePaths("Id")
                .withIgnorePaths("Orderid")
                .withIgnorePaths("json")
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT));
    

        final  var deliveryFind= DeliveryOrderRepository.findAll(deliveryEntityExample);
        List<DeliveryOrderEntity> deliveryOrders = deliveryFind;

        List<DeliberyOrderDTO> deliberyOrderDTOList=new ArrayList<DeliberyOrderDTO>();
        if(deliveryOrders == null){
            return deliberyOrderDTOList;
        }
        for (DeliveryOrderEntity deliveryOrder: deliveryOrders) {
            deliberyOrderDTOList.add(deliveryOrder.getJson());
        }

        return deliberyOrderDTOList;
    }

    @Override
    @Transactional
    public DeliveryDTO createOrUpdate(DeliveryDTO data) {
    
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setAccountName(data.getAccount());
        deliveryEntity.setGuideNumber(data.getGuideNumber());
        deliveryEntity.setOrderId(data.getOrderNumber());
        deliveryEntity.setSellerName(data.getSellerName());

        Example<DeliveryEntity> deliveryEntityExample = Example.of(deliveryEntity, ExampleMatcher.matchingAll()
        .withIgnoreNullValues()
        .withIgnorePaths("DeliveryId")
        .withIgnorePaths("Accountid")
        .withIgnorePaths("SellerId")
        .withIgnorePaths("TrackingUrl")
        .withIgnorePaths("DownloadDate")
        .withStringMatcher(ExampleMatcher.StringMatcher.EXACT));
        
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
        DeliveryStateEntity deliveryStateEntity = new DeliveryStateEntity();
        deliveryStateEntity.setAccountName(data.getAccount());
        deliveryStateEntity.setGuideNumber(data.getGuidenumber());
        deliveryStateEntity.setOrderId(data.getOrdernumber());
        deliveryStateEntity.setSellerName(data.getSellername());
        deliveryStateEntity.setState(data.getStatus());

        Example<DeliveryStateEntity> deliveryEntityExample = Example.of(deliveryStateEntity, ExampleMatcher.matchingAll()
        .withIgnoreNullValues()
        .withIgnorePaths("DeliveryStateId")
        .withIgnorePaths("AccountId")
        .withIgnorePaths("TrackingUrl")
        .withIgnorePaths("Description")
        .withIgnorePaths("DownloadDate")
        .withIgnorePaths("Evidence")
        .withStringMatcher(ExampleMatcher.StringMatcher.EXACT));
        
      final  var deliveryFind= DeliveryStatusRepository.findOne(deliveryEntityExample);
      
      var deliveryState = deliveryFind.orElse(null);

      if (deliveryFind.isEmpty()) {
        deliveryState=DeliveryStateAdapter.fromDTO(data);
         DeliveryStatusRepository.save(deliveryState);
      }



        final var deliveryStateRef=deliveryState;
        final var evidences = data.getEvidences()
        .stream()
        .map(i -> DeliveryEvidenceAdapter.fromDTO(i, deliveryStateRef))
        .collect(Collectors.toList());

        deliveryState.getEvidence().addAll(evidences);

        DeliveryStatusRepository.save(deliveryState);

        return DeliveryStateAdapter.fromEntity(deliveryState);
    }



    

}
