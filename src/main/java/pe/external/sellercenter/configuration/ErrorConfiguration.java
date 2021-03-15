package pe.external.sellercenter.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import pe.external.sellercenter.domain.exceptions.AppException;
import pe.external.sellercenter.domain.exceptions.ErrorDTO;
import pe.external.sellercenter.domain.exceptions.ValidationErrorDTO;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


@ControllerAdvice
public class ErrorConfiguration {
    final Logger log = LogManager.getLogger(ErrorConfiguration.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<Object> handleDefaultConflict(Exception ex, WebRequest request) {
        if ( !(ex instanceof HttpRequestMethodNotSupportedException) &&
                !(ex instanceof HttpMediaTypeNotSupportedException)) {
            log.error("Server error: " + ex.getMessage(), ex);
        }

        final var error = new ErrorDTO();
        error.setMessage("Server error");
        error.setStackMessage(ex.getMessage());
        error.setStack(Arrays.stream(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.toList())
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler(value = { AppException.class })
    protected ResponseEntity<ErrorDTO> handleGeneralConflict(AppException ex, WebRequest request) {
        final var headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON.toString() + ";charset=utf-8");

        if (ex.getMessage() != null) {
            final var error = new ErrorDTO();
            error.setMessage(ex.getMessage());

            return ResponseEntity
                    .status(ex.getStatus())
                    .headers(headers)
                    .body(error);
        }

        return ResponseEntity
                .status(ex.getStatus())
                .headers(headers)
                .build();
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<ErrorDTO> handleConstraintConflict(ConstraintViolationException ex, WebRequest request) {
        final var error = new ErrorDTO();
        error.setMessage(ex.getMessage());
        error.setStackMessage(ex.getMessage());

        final var headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON.toString() + ";charset=utf-8");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .headers(headers)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleConstraintConflict(MethodArgumentNotValidException ex, WebRequest request) {

        final var error = new ErrorDTO();
        error.setMessage("The request data is incorrect");
        error.setValidations(new ArrayList<>());

        final var errs = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> error.getValidations().add(new ValidationErrorDTO(e.getField(), e.getDefaultMessage())))
                .collect(Collectors.toList());

        final var headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON.toString() + ";charset=utf-8");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(error);
    }
}
