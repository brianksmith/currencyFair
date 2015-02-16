package interview.test.currency.fair.markettrade.producer;

import interview.test.currency.fair.markettrade.domain.TradeOrder;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MarketTradeProducer {
	
	private JmsTemplate jmsTemplate;

	public MarketTradeProducer(JmsTemplate jmsTemplate) {
		this.jmsTemplate=jmsTemplate;
	}
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessages(final TradeOrder tradeOrder) throws JMSException {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(tradeOrder);
			}
		});
	}
}
