package pe.external.sellercenter.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDTO {

@JsonProperty("Account")
private String Account;
@ApiModelProperty(notes = "Size can't exceed 50 characters")
@Size(max = 50, message = "Field 'OrderNumber' can't exceed 50 characters")
@JsonProperty("OrderNumber")
 private String OrderNumber;
 @ApiModelProperty(notes = "Size can't exceed 50 characters")
@Size(max = 50, message = "Field 'SellerName' can't exceed 50 characters")
@JsonProperty("SellerName")
 private String SellerName;
 @ApiModelProperty(notes = "Size can't exceed 50 characters")
 @Size(max = 50, message = "Field 'GuideNumber' can't exceed 50 characters")
 @JsonProperty("GuideNumber")
 private String GuideNumber;
 @ApiModelProperty(notes = "Size can't exceed 300 characters")
 @Size(max = 300, message = "Field 'TrackingUrl' can't exceed 300 characters")
 @JsonProperty("TrackingUrl")
 private String TrackingUrl;

 private Long Id;

}
