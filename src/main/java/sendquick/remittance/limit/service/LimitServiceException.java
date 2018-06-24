package sendquick.remittance.limit.service;

public class LimitServiceException extends RuntimeException {

    private String message;

    public LimitServiceException(String message) {
        super(message);
        this.message = message;
    }

}
