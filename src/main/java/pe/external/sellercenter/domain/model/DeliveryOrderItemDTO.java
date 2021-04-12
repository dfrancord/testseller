package pe.external.sellercenter.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryOrderItemDTO{
    public String id;
    public String description;
    public String quantity;
    public String weight;
    public String volWeight;
    public String price;
    public String width;
    public String height;
    public String lenght;
}