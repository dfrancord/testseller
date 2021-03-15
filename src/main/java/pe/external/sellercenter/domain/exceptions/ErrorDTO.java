package pe.external.sellercenter.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO {
    private String message;
    private String stackMessage;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeUTC = LocalDateTime.now(ZoneOffset.UTC);
    private List<String> stack;
    private List<ValidationErrorDTO> validations;
}
