package interview.test.currency.fair.markettrade.controller;

import interview.test.currency.fair.markettrade.domain.TradeOrder;
import interview.test.currency.fair.markettrade.metrics.RedisMetricsService;
import interview.test.currency.fair.markettrade.producer.MarketTradeProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MarketTradeProducer marketTradeProducer;

	@Autowired
	private RedisMetricsService redisMetricsService;

	private CurrencyRquestValidator validator = new CurrencyRquestValidator();
		
	@RequestMapping(value = "/currency/trade", headers ={"Accept=application/json"}, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> welcome(@Validated @RequestBody TradeOrder tradeOrder) {
		ResponseEntity<String> validated = validator.validate(tradeOrder);
		if (validated.getStatusCode().equals(HttpStatus.OK)) {
			try {
				marketTradeProducer.sendMessages(tradeOrder);
			} catch (Exception e) {
				logger.error("Error persisting data {}", new Gson().toJson(tradeOrder));
				logger.error("Error persisting data ", e);
			}
		}		
		return validated;
	}
	
	@RequestMapping(value = "donut")
	public String donut(ModelMap model) {
		model.addAttribute("data", redisMetricsService.getCurrencyByConversionMetricData());
		return "donut";
	}
}
