package pe.external.sellercenter.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryStatusDTO {
    @JsonProperty("Account")
    private String account;
    @ApiModelProperty(notes = "Size can't exceed 50 characters")
@Size(max = 50, message = "Field 'OrderNumber' can't exceed 50 characters")
@JsonProperty("OrderNumber")
    private String ordernumber;
    @ApiModelProperty(notes = "Size can't exceed 50 characters")
@Size(max = 50, message = "Field 'SellerName' can't exceed 50 characters")
@JsonProperty("SellerName")
    private String sellername;
    @ApiModelProperty(notes = "Size can't exceed 50 characters")
@Size(max = 50, message = "Field 'GuideNumber' can't exceed 50 characters")
@JsonProperty("GuideNumber")
    private String guidenumber;
    @ApiModelProperty(notes = "Size can't exceed 300 characters")
    @Size(max = 300, message = "Field 'TrackingUrl' can't exceed 300 characters")
    @JsonProperty("TrackingUrl")
    private String trackingurl;
    @ApiModelProperty(notes = "Size can't exceed 50 characters")
    @Size(max = 50, message = "Field 'Status' can't exceed 50 characters")
    @JsonProperty("Status")
    private String status;
    @JsonProperty("StatusDescription")
    private String StatusDescription;
    @JsonProperty("Evidences")
    List <DeliveryEvidenceDTO> evidences = new ArrayList <DeliveryEvidenceDTO> ();
}
