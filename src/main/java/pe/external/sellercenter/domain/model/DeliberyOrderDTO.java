package pe.external.sellercenter.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliberyOrderDTO{
    public String marketplaceId;
    public String sellerCorporateDocument;
    public String sellerCorporateName;
    public String sellerAddress;
    public String sellerPhone;
    public String sellerEmail;
    public String sellerUbigeo;
    public String clientDocumentType;
    public String clientDocument;
    public String clientFirstName;
    public String clientLastName;
    public String clientAddressStreet;
    public String clientAddressNumber;
    public String clientAddressComplement;
    public String clientAddressReference;
    public String clientReceiverName;
    public String clientReceiverDocument;
    public String clientPhone;
    public String clientEmail;
    public String clientUbigeo;
    public String itemsQuantity;
    public String orderWeight;
    public String orderVolWeight;
    public String orderNumber;
    public String currencyCode;
    public int totalValue;
    public List<DeliveryOrderItemDTO> items;
}