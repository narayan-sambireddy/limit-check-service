package sendquick.remittance.limit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sendquick.remittance.limit.LimitServiceApp;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.service.LimitService;

@RestController
@RequestMapping("/sendquick/remittance/limit")
public class LimitController {

    private final LimitService limitService;

    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @GetMapping
    public AccountLimit fetch(@RequestParam String customerId) {
        AccountLimitEntity accountLimitEntity = limitService.fetch(customerId);
        AccountLimit accountLimit = new AccountLimit();
        accountLimit.setCustomerId(accountLimitEntity.getCustomerId());
        accountLimit.setDailyLimit(accountLimitEntity.getDailyLimit());
        return accountLimit;
    }

    @PutMapping
    public AccountLimitEntity save(@RequestBody AccountLimitEntity accountLimit) {
        AccountLimitEntity savedLimit = limitService.save(accountLimit);
        return savedLimit;
    }

    @PostMapping
    public ValidationResult validate(@RequestBody TransactionLimit transactionLimit) {
        ValidationResult result = limitService.validate(transactionLimit);
        return result;
    }

}

