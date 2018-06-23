package sendquick.remittance.limit.domain;

public class ValidationResult {

    private String message;

    private boolean valid;

    public ValidationResult() {
        this.valid = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
