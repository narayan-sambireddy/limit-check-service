package sendquick.remittance.limit.transformer;

import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.entity.AccountLimitEntity;

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
}
