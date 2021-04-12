package pe.external.sellercenter.domain.service;


import pe.external.sellercenter.domain.model.DeliberyOrderDTO;
import pe.external.sellercenter.domain.model.DeliveryDTO;

import java.util.List;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;

public interface IDeliveryService {
    DeliveryDTO createOrUpdate(DeliveryDTO data);
    DeliveryStatusDTO createOrUpdateStatus(DeliveryStatusDTO data);
    List<DeliberyOrderDTO> GetOrderSeller(String Seller);
    List<DeliberyOrderDTO> GetOrderSeller(String Seller,String Orderid);
}

