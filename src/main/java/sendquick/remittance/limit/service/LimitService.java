package sendquick.remittance.limit.service;

import org.springframework.stereotype.Service;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.repo.AccountLimitRepo;
import sendquick.remittance.limit.repo.TransactionLimitRepo;

import static sendquick.remittance.limit.transformer.LimitDomainTransformer.*;

/**
 * @author narayana
 */
@Service
public class LimitService {

    private final AccountLimitRepo accountLimitRepo;
    private final TransactionLimitRepo transactionLimitRepo;
    private final LimitsValidator limitsValidator;

    public LimitService(AccountLimitRepo accountLimitRepo, TransactionLimitRepo transactionLimitRepo, LimitsValidator limitsValidator) {
        this.accountLimitRepo = accountLimitRepo;
        this.transactionLimitRepo = transactionLimitRepo;
        this.limitsValidator = limitsValidator;
    }

    public AccountLimit fetch(String customerId) {
        AccountLimitEntity entity = accountLimitRepo.getOne(customerId);
        return accountEntityToDomain.apply(entity);
    }

    public ValidationResult validate(TransactionLimit transactionLimit) {
        ValidationResult result = new ValidationResult();
        AccountLimit accountLimit = fetch(transactionLimit.getCustomerId());

        limitsValidator.checkRemittanceNotAllowedInCoolOffHours.accept(transactionLimit.getPayeeCreationDate());
        limitsValidator.checkRemitAmountShouldNotExceedDailyLimit.accept(transactionLimit.getRemitAmount(), accountLimit.getRemainingDailyLimit());
        limitsValidator.checkRemitAmountShouldNotExceedYearlyLimit.accept(transactionLimit.getRemitAmount(), accountLimit.getRemainingYearlyLimit());

        return result;
    }

    public AccountLimit save(AccountLimit accountLimit) {
        double dailyLimit = accountLimit.getDailyLimit();
        limitsValidator.checkDailyLimitShouldNotBeLessThanMinTransactionAmount.accept(dailyLimit);
        limitsValidator.checkDailyLimitShouldNotExceedYearlyLimit.accept(dailyLimit);
        AccountLimitEntity entity = accountLimitRepo.save(accountDomainToEntity.apply(accountLimit));
        return accountEntityToDomain.apply(entity);
    }
}
