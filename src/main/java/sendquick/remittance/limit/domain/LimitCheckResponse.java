package sendquick.remittance.limit.domain;

/**
 *
 * @author narayana
 *
 */
public class LimitCheckResponse<T> {

    T data;
    boolean error;
    boolean errorMsg;
    Integer code;

    private LimitCheckResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> LimitCheckResponse<T> of(Integer code, T data) {
        return new LimitCheckResponse<T>(code, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(boolean errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
