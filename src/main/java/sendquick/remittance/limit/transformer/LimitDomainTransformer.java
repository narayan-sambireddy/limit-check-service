package sendquick.remittance.limit.transformer;

import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.entity.TransactionLimitEntity;

import java.util.function.Function;

/**
 * @author narayana
 */
public class LimitDomainTransformer {

    public static Function<AccountLimitEntity, AccountLimit> accountEntityToDomain = (entity) ->
        new AccountLimit() {{
            setCustomerId(entity.getCustomerId());
            setDailyLimit(entity.getDailyLimit());
            setRemainingDailyLimit(entity.getRemainingDailyLimit());
            setYearlyLimit(entity.getYearlyLimit());
            setRemainingYearlyLimit(entity.getRemainingYearlyLimit());
            setLastModifiedDate(entity.getLastModifiedDate());
        }};

    public static Function<AccountLimit, AccountLimitEntity> accountDomainToEntity = (domain) -> {
        AccountLimitEntity entity = new AccountLimitEntity();
        entity.setCustomerId(domain.getCustomerId());
        entity.setDailyLimit(domain.getDailyLimit());
        entity.setRemainingDailyLimit(domain.getRemainingDailyLimit());
        entity.setYearlyLimit(domain.getYearlyLimit());
        entity.setRemainingYearlyLimit(domain.getRemainingYearlyLimit());
        entity.setLastModifiedDate(domain.getLastModifiedDate());
        return entity;
    };

    public static Function<TransactionLimitEntity, TransactionLimit> transactionEntityToDomain = (entity) ->
        new TransactionLimit() {{
            setCustomerId(entity.getCustomerId());
            setPayeeId(entity.getPayeeId());
            setRemitAmount(entity.getRemitAmount());
            setSourceCountry(entity.getSourceCountry());
            setSourceCurrency(entity.getSourceCurrency());
            setDestinationCountry(entity.getDestinationCountry());
            setDestinationCurrency(entity.getDestinationCurrency());
            setExchangeRateUSD(entity.getExchangeRateUSD());
        }};

    public static Function<TransactionLimit, TransactionLimitEntity> transactionDomainToEntity = (domain) -> {
        TransactionLimitEntity entity = new TransactionLimitEntity();
        entity.setCustomerId(domain.getCustomerId());
        entity.setPayeeId(domain.getPayeeId());
        entity.setRemitAmount(domain.getRemitAmount());
        entity.setSourceCountry(domain.getSourceCountry());
        entity.setSourceCurrency(domain.getSourceCurrency());
        entity.setDestinationCountry(domain.getDestinationCountry());
        entity.setDestinationCurrency(domain.getDestinationCurrency());
        entity.setExchangeRateUSD(domain.getExchangeRateUSD());
        return entity;
    };

}
