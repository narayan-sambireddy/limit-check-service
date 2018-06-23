package sendquick.remittance.limit.service;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LimitServiceResponse {

    private String errorMessage;
    private boolean hasError;
    private Object data;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
