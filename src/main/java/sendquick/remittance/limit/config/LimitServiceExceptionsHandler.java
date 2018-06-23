package sendquick.remittance.limit.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sendquick.remittance.limit.service.LimitServiceResponse;

/**
 * @author narayana
 */
@RestControllerAdvice
public class LimitServiceExceptionsHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<LimitServiceResponse> exceptionHandlerOne(Exception ex) {
        LimitServiceResponse lsr = new LimitServiceResponse();
        lsr.setErrorMessage(ex.getMessage());
        lsr.setHasError(true);
        return ResponseEntity.ok(lsr);
    }
	
}
