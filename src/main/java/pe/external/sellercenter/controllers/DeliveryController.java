package pe.external.sellercenter.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pe.external.sellercenter.domain.model.DeliveryDTO;
import pe.external.sellercenter.domain.model.DeliveryStatusDTO;
import pe.external.sellercenter.domain.service.IDeliveryService;

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
    public String getAllOrders(String sellername) 
    {
        String jsonExample ="[\r\n{\r\n    \"marketplaceId\": \"1\",\r\n    \"sellerCorporateDocument\": \"10462108422\",\r\n    \"sellerCorporateName\": \"SANTOS TEVEZ JACKELINE\",\r\n    \"sellerAddress\": \"Mz 6b LT 22 Urb los jardines sjl\",\r\n    \"sellerPhone\": \"+5171234567\",\r\n    \"sellerEmail\": \"Jsantosg23@gmail.com\",\r\n    \"sellerUbigeo\": \"150118\",\r\n    \"clientDocumentType\": \"DNI\",\r\n    \"clientDocument\": \"08612398\",\r\n    \"clientFirstName\": \"Margarita\",\r\n    \"clientLastName\": \"Villalobos La Madrid\",\r\n    \"clientAddressStreet\": \"Jr.Tauro\",\r\n    \"clientAddressNumber\": \"845\",\r\n    \"clientAddressComplement\": \"Departamento 201\",\r\n    \"clientAddressReference\": \"a la espalda de la municipalidad\",\r\n    \"clientReceiverName\": \"Margarita Villalobos La Madrid\",\r\n    \"clientReceiverDocument\": \"08612398\",\r\n    \"clientPhone\": \"953502911\",\r\n    \"clientEmail\": \"naranjita_2709@hotmail.com\",\r\n    \"clientUbigeo\": \"150117\",\r\n    \"itemsQuantity\": \"1\",\r\n    \"orderWeight\": \"0.400\",\r\n    \"orderVolWeight\": \"0.200\",\r\n    \"orderNumber\": \"1112432309043-02\",\r\n    \"currencyCode\": \"PEN\",\r\n    \"totalValue\": 3100,\r\n    \"items\": [{\r\n            \"id\": \"1598404894191\",\r\n            \"description\": \"Set de 3 Bandas El\u00E1sticas de Resistencia Todo Fit\",\r\n            \"quantity\": \"1\",\r\n            \"weight\": \"0.400\",\r\n            \"volWeight\": \"0.200\",\r\n            \"price\": \"79\",\r\n            \"width\": \"10.0\",\r\n            \"height\": \"10.0\",\r\n            \"lenght\": \"10.0\"\r\n        },\r\n        {\r\n            \"id\": \"159840489344191\",\r\n            \"description\": \"TV LG SMART TV 55'\",\r\n            \"quantity\": \"1\",\r\n            \"weight\": \"4.5\",\r\n            \"volWeight\": \"4.0\",\r\n            \"price\": \"2999\",\r\n            \"width\": \"23.0\",\r\n            \"height\": \"55.0\",\r\n            \"lenght\": \"123.0\"\r\n        }\r\n    ]\r\n}\r\n]";
        
        return jsonExample;
    }

}

