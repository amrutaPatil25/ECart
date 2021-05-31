package com.cart.app.feginclient;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="bank-service", url="http://localhost:8123/bank/accounts")
public interface ECartBankClient {
	
	@PutMapping
	public String fundTransfer(@Valid @Size(message="to account number required")@RequestParam Integer fromAccount,
			@Valid @Size(message="from account number required") @RequestParam Integer toAccount,
			@Valid @Size(message="amount required")@RequestParam double amount);
}
