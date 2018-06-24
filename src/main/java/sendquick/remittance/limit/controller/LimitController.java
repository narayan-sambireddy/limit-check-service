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
        return limitService.fetch(customerId);
    }

    @PutMapping
    public AccountLimit save(@RequestBody AccountLimit accountLimit) {
        return limitService.save(accountLimit);
    }

    @PostMapping
    public ValidationResult validate(@RequestBody TransactionLimit transactionLimit) {
        ValidationResult result = limitService.validate(transactionLimit);
        return result;
    }

}

