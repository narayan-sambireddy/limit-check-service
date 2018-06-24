package sendquick.remittance.limit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sendquick.remittance.limit.domain.ValidationResult;

import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author narayana
 */
@Service
public class LimitsValidator {

    @Value("${YEARLY_LIMIT}")
    private Double YEARLY_LIMIT;

    @Value("${MIN_REMIT_AMT}")
    private Double MIN_REMIT_AMT;

    @Value("${COOL_OF_HOURS}")
    private Integer COOL_OF_HOURS;


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

    Consumer<Double> newDailyLimitShouldNotExceedYearlyLimit =  dailyLimit -> {
        if (dailyLimit > YEARLY_LIMIT)
            throw new LimitServiceException(DAILY_LIMIT_EXCEEDS_YEARLY_LIMIT);
    };

    Consumer<Double> newDailyLimitShouldNotBeLessThanMinTransactionAmount = dailyLimit -> {
        if (dailyLimit < MIN_REMIT_AMT)
            throw new LimitServiceException(DAILY_LIMIT_FALLS_BELOW_MIN_TRANSACTION_AMT);
    };

    BiConsumer<Double, Double> remitAmountShouldNotExceedDailyLimit = (remitAmount, remainingDailyLimit) -> {
        if (remitAmount > remainingDailyLimit)
            throw new LimitServiceException(REMIT_AMT_EXCEEDS_DAILY_LIMIT);
    };

    BiConsumer<Double, Double> remitAmountShouldNotExceedYearlyLimit = (remitAmount, remainingYearlyLimit) -> {
        if (remitAmount > remainingYearlyLimit)
            throw new LimitServiceException(REMIT_AMT_EXCEEDS_YEARLY_LIMIT);
    };

    Consumer<Date> remittanceNotAllowedInCoolOffHours = payeeCreationDate -> {
        long nowInMillis = System.currentTimeMillis() - payeeCreationDate.getTime();
        long coolOffInMillis = HOUR_IN_MILLIS * COOL_OF_HOURS;
        if (nowInMillis < coolOffInMillis)
            throw new LimitServiceException(REMITTANCE_NOT_ALLOWED_IN_COOL_OFF_HOURS);

    };

}
