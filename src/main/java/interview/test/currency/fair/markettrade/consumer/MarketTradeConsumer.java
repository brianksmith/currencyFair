package interview.test.currency.fair.markettrade.consumer;

import interview.test.currency.fair.markettrade.domain.TradeOrder;
import interview.test.currency.fair.markettrade.metrics.RedisMetricsService;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;

public class MarketTradeConsumer implements MessageListener {

	@Autowired
	private RedisMetricsService redisMetricsService;
	
	@Override
	public void onMessage(Message message) {
		try {
		if (message instanceof ObjectMessage) {
				Object obj = ((ObjectMessage) message).getObject();
				if (obj instanceof TradeOrder) {
					redisMetricsService.addToCurrencyByConversionMetrics((TradeOrder) obj);
				}
			}
		} catch (Exception e) {}
	}

}
