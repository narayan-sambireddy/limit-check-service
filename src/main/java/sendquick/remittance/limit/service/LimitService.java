package sendquick.remittance.limit.service;

import org.springframework.stereotype.Service;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.repo.AccountLimitRepo;
import sendquick.remittance.limit.repo.TransactionLimitRepo;

import static sendquick.remittance.limit.transformer.LimitDomainTransformer.*;

import java.util.function.Function;

/**
 * @author narayana
 */
@Service
public class LimitService {

    private AccountLimitRepo accountLimitRepo;
    private final TransactionLimitRepo transactionLimitRepo;

    public LimitService(AccountLimitRepo accountLimitRepo, TransactionLimitRepo transactionLimitRepo) {
        this.accountLimitRepo = accountLimitRepo;
        this.transactionLimitRepo = transactionLimitRepo;
    }

    public AccountLimit fetch(String customerId) {
        AccountLimitEntity entity = accountLimitRepo.getOne(customerId);
        return accountEntityToDomain.apply(entity);
    }

    public ValidationResult validate(TransactionLimit transactionLimit) {
        return null;
    }

    public AccountLimit save(AccountLimit accountLimit) {
        AccountLimitEntity entity = accountLimitRepo.save(accountDomainToEntity.apply(accountLimit));
        return accountEntityToDomain.apply(entity);
    }
}
