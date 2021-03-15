package pe.external.sellercenter.domain.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryEvidenceDTO {

    @JsonProperty("evidence_url")
    private String evidenceurl;
}
