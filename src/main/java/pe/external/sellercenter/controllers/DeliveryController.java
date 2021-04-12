package pe.external.sellercenter.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pe.external.sellercenter.domain.model.DeliberyOrderDTO;
import pe.external.sellercenter.domain.model.DeliveryDTO;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;
import pe.external.sellercenter.domain.service.IDeliveryService;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/Delivery/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryController {

    @Autowired IDeliveryService service;

    @PostMapping("/guide")
    public DeliveryDTO createOrUpdate(@Valid @RequestBody DeliveryDTO data) {
        return service.createOrUpdate(data);
    }

    @PostMapping("/guide/state")
    public DeliveryStatusDTO createOrUpdateState(@Valid @RequestBody DeliveryStatusDTO data) {
        return service.createOrUpdateStatus(data);
    }

    @GetMapping(value = "/orders/{sellername}")
    public List<DeliberyOrderDTO> getAllOrders(String sellername) 
    {
        return service.GetOrderSeller(sellername);
    }

    @GetMapping(value = "/orders/{sellername}/{Orderid}")
    public List<DeliberyOrderDTO>  getSellerOrder(String sellername, String Orderid)
    {
        return service.GetOrderSeller(sellername,Orderid);
    }

}

