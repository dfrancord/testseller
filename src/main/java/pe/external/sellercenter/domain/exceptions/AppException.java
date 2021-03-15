package pe.external.sellercenter.domain.exceptions;


import lombok.Getter;

public class AppException extends RuntimeException {
    @Getter
    private final int status;
    @Getter
    private final String message;

    public AppException(String message, int status) {
        super();
        this.status = status;
        this.message = message;
    }
}
