package sendquick.remittance.limit.validators;

import org.springframework.beans.factory.annotation.Value;
import sendquick.remittance.limit.domain.ValidationResult;

import javax.validation.Valid;
import java.util.Date;
import java.util.function.BiFunction;

/**
 * @author narayana
 */
public class LimitsValidator {

    @Value("${DAILY_LIMIT_EXCEEDS_YEARLY_LIMIT}")
    private String DAILY_LIMIT_EXCEEDS_YEARLY_LIMIT;

    @Value("${DAILY_LIMIT_FALLS_BELOW_MIN_TRANSACTION_AMT}")
    private String DAILY_LIMIT_FALLS_BELOW_MIN_TRANSACTION_AMT;

    @Value("${REMIT_AMT_EXCEEDS_DAILY_LIMIT}")
    private String REMIT_AMT_EXCEEDS_DAILY_LIMIT;

    @Value("${REMIT_AMT_EXCEEDS_DAILY_LIMIT}")
    private String REMIT_AMT_EXCEEDS_YEARLY_LIMIT;

    @Value("${REMITTANCE_NOT_ALLOWED_IN_COOL_OFF_HOURS}")
    private String REMITTANCE_NOT_ALLOWED_IN_COOL_OFF_HOURS;

    private static final Long HOUR_IN_MILLIS = 60 * 60 * 1000L;

    private BiFunction<Double, Double, ValidationResult> newDailyLimitShouldNotExceedYearlyLimit =
        (dailyLimit, yearlyLimit) -> new ValidationResult() {{
            if(dailyLimit > yearlyLimit) {
                setValid(false);
                setMessage(DAILY_LIMIT_EXCEEDS_YEARLY_LIMIT);
            }
        }};

    private BiFunction<Double, Double, ValidationResult> newDailyLimitShouldNotBeLessThanMinTransactionAmount =
        (dailyLimit, minTransactionAmt) -> new ValidationResult() {{
            if(dailyLimit < minTransactionAmt) {
                setValid(false);
                setMessage(DAILY_LIMIT_FALLS_BELOW_MIN_TRANSACTION_AMT);
            }
        }};

    private BiFunction<Double, Double, ValidationResult> remitAmountExceedsDailyLimit =
        (remitAmount, remainingDailyLimit) -> new ValidationResult() {{
            if(remitAmount > remainingDailyLimit) {
                setValid(false);
                setMessage(REMIT_AMT_EXCEEDS_DAILY_LIMIT);
            }
        }};

    private BiFunction<Double, Double, ValidationResult> remitAmountExceedsYearlyLimit =
        (remitAmount, remainingYearlyLimit) -> new ValidationResult() {{
            if(remitAmount > remainingYearlyLimit) {
                setValid(false);
                setMessage(REMIT_AMT_EXCEEDS_YEARLY_LIMIT);
            }
        }};

    private BiFunction<Date,Integer, ValidationResult> remittanceNotAllowedInCoolOffHours =
        (payeeCreationDate, coolOffHours) -> new ValidationResult() {{
            long payeeCreationTime = payeeCreationDate.getTime();
            long coolOffInMillis = HOUR_IN_MILLIS * coolOffHours;
            long nowInMillis = System.currentTimeMillis() - payeeCreationTime;
            if(nowInMillis < coolOffInMillis) {
                setValid(false);
                setMessage(REMITTANCE_NOT_ALLOWED_IN_COOL_OFF_HOURS);
            }
        }};

}
