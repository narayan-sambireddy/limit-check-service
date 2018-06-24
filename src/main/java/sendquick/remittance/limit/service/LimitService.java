package sendquick.remittance.limit.service;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Service;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.entity.TransactionLimitEntity;
import sendquick.remittance.limit.repo.AccountLimitRepo;
import sendquick.remittance.limit.repo.TransactionLimitRepo;

import java.util.Date;

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

    public ValidationResult validate(TransactionLimit tranLimit) {
        ValidationResult result = new ValidationResult();
        TransactionLimitEntity transactionLimitEntity = transactionDomainToEntity.apply(tranLimit);
        transactionLimitEntity.setStatus("SUCCESS");

        Date payeeCreationDate = null;
        try {
            AccountLimit acctLimit = fetch(tranLimit.getCustomerId());

            TransactionLimitEntity previousTransaction = transactionLimitRepo.findFirstByCustomerIdAndPayeeIdOrderByCreatedDateDesc(
                    tranLimit.getCustomerId(), tranLimit.getPayeeId());

            if(previousTransaction != null) {
                payeeCreationDate = previousTransaction.getPayeeCreationDate(); //TODO:: fetch from payee-service
            }else {
                //FETCH payeeCreationDate FROM payee-service
                payeeCreationDate = new Date();
            }
            transactionLimitEntity.setPayeeCreationDate(payeeCreationDate);
            limitsValidator.checkDailyLimitShouldNotBeLessThanMinTransactionAmount.accept(tranLimit.getRemitAmount());
            limitsValidator.checkRemittanceNotAllowedInCoolOffHours.accept(payeeCreationDate);
            limitsValidator.checkRemitAmountShouldNotExceedDailyLimit.accept(tranLimit.getRemitAmount(), acctLimit.getRemainingDailyLimit());
            limitsValidator.checkRemitAmountShouldNotExceedYearlyLimit.accept(tranLimit.getRemitAmount(), acctLimit.getRemainingYearlyLimit());
        }catch (Exception ex) {
            transactionLimitEntity.setStatus("FAILED");
            transactionLimitEntity.setRemarks(ex.getMessage());
            throw ex;
        }finally {
            transactionLimitRepo.save(transactionLimitEntity);
        }

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
