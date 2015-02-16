package interview.test.currency.fair.markettrade.metrics;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import interview.test.currency.fair.markettrade.domain.TradeOrder;

public class RedisMetricsService {

	private static final String BY_CONVERSION = "byConversion";
	
	private Jedis jedis;
	
	public RedisMetricsService() {
		jedis = new Jedis("localhost");
	}
	
	public void addToCurrencyByConversionMetrics(TradeOrder tradeOrder) {
		String key = String.format("%s-%s", tradeOrder.getCurrencyFrom(), tradeOrder.getCurrencyTo());
		jedis.zincrby(BY_CONVERSION, 1.0, key);
	}
	
	public String getCurrencyByConversionMetricData() {
		StringBuilder builder = new StringBuilder(1000);
		Set<Tuple> set = jedis.zrangeWithScores(BY_CONVERSION, 0, -1);	
		if (set != null) {
			builder.append("[['Currency', 'Exchanges']");
			for (Tuple tuple : set) {
				builder.append(String.format(",['%s', %f]", tuple.getElement(), tuple.getScore()));
			}
			builder.append("]");
		}
		return builder.toString();
	}
	
}
