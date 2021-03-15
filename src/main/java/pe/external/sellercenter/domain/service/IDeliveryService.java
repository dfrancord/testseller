package pe.external.sellercenter.domain.service;

import pe.external.sellercenter.domain.model.DeliveryDTO;

import pe.external.sellercenter.domain.model.DeliveryStatusDTO;

public interface IDeliveryService {
    DeliveryDTO createOrUpdate(DeliveryDTO data);
    DeliveryStatusDTO createOrUpdateStatus(DeliveryStatusDTO data);
}

