package sendquick.remittance.limit.service;

import org.springframework.stereotype.Service;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.repo.AccountLimitRepo;
import sendquick.remittance.limit.repo.TransactionLimitRepo;

@Service
public class LimitService {

    private AccountLimitRepo accountLimitRepo;
    private final TransactionLimitRepo transactionLimitRepo;

    public LimitService(AccountLimitRepo accountLimitRepo, TransactionLimitRepo transactionLimitRepo) {
        this.accountLimitRepo = accountLimitRepo;
        this.transactionLimitRepo = transactionLimitRepo;
    }

    public AccountLimitEntity fetch(String customerId) {
        return accountLimitRepo.getOne(customerId);
    }

    public ValidationResult validate(TransactionLimit transactionLimit) {
        return null;
    }

    public AccountLimitEntity save(AccountLimitEntity accountLimit) {
        return accountLimitRepo.save(accountLimit);
    }
}
