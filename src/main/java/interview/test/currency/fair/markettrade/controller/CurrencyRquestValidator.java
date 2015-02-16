package interview.test.currency.fair.markettrade.controller;

import interview.test.currency.fair.markettrade.domain.TradeOrder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CurrencyRquestValidator {
	public static final ResponseEntity<String> SUCCESS = new ResponseEntity<String>(HttpStatus.OK);
	
	/**
	 * Check all input parameters to make sure the request is valid. for brevity 
	 *   I have only included a few brief checks
	 * 
	 * @param tradeOrder
	 * @return
	 */
	public ResponseEntity<String> validate(TradeOrder tradeOrder) {
		ResponseEntity<String> validated=SUCCESS;
		
		if (StringUtils.isBlank(tradeOrder.getCurrencyFrom())) {
			validated=new ResponseEntity<>("currencyFrom not found in request", HttpStatus.BAD_REQUEST);
		} else if (StringUtils.isBlank(tradeOrder.getCurrencyTo())) {
			validated=new ResponseEntity<>("currencyTo not found in request", HttpStatus.BAD_REQUEST);
		} else if (tradeOrder.getAmountBuy() == null) {
			validated=new ResponseEntity<>("amountBuy not found in request", HttpStatus.BAD_REQUEST);
		} else if (tradeOrder.getAmountBuy() <= 0) {
			validated=new ResponseEntity<>("amountBuy must by > 0", HttpStatus.BAD_REQUEST);
		}  else if (tradeOrder.getAmountSell() == null) {
			validated=new ResponseEntity<>("amountSell not found in request", HttpStatus.BAD_REQUEST);
		} else if (tradeOrder.getAmountSell() <= 0) {
			validated=new ResponseEntity<>("amountSell must by > 0", HttpStatus.BAD_REQUEST);
		} 
		// add as may rules as needed to verify object is valid request
		//  maybe check for sell * rate = amountBuy, verify currency rate, validate time, etc..
		return validated;
	}
}
