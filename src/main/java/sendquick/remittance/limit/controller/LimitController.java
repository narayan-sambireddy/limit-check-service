package sendquick.remittance.limit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sendquick.remittance.limit.LimitServiceApp;
import sendquick.remittance.limit.domain.AccountLimit;
import sendquick.remittance.limit.domain.TransactionLimit;
import sendquick.remittance.limit.domain.ValidationResult;
import sendquick.remittance.limit.entity.AccountLimitEntity;
import sendquick.remittance.limit.service.LimitService;

/**
 * @author narayana
 */
@RestController
@RequestMapping("/quicksend/remittance/limit")
@Api(value="remittance-limit", description="Operations pertaining to remittance limit and validation")
public class LimitController {

    private final LimitService limitService;

    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @GetMapping
    @ApiOperation(value = "Fetch remittance limits for a customer", response = AccountLimit.class)
    public AccountLimit fetch(@RequestParam String customerId) {
        return limitService.fetch(customerId);
    }

    @PutMapping
    @ApiOperation(value = "Save / Update remittance limits for a customer", response = AccountLimit.class)
    public AccountLimit save(@RequestBody AccountLimit accountLimit) {
        return limitService.save(accountLimit);
    }

    @PostMapping
    @ApiOperation(value = "Validates remit amount against the limits for : bank / account / transaction", response = ValidationResult.class)
    public ValidationResult validate(@RequestBody TransactionLimit transactionLimit) {
        return limitService.validate(transactionLimit);
    }

}

