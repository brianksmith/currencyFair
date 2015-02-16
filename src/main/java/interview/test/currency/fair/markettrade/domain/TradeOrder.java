package interview.test.currency.fair.markettrade.domain;

import java.io.Serializable;

public class TradeOrder implements Serializable {

	private static final long serialVersionUID = 6399592139678629171L;

	private String userId;
	
	private String currencyFrom;
	
	private String currencyTo;
	
	private Integer amountSell;
	
	private Integer amountBuy;
	
	private Float rate;
	
	private String timePlaced;
	
	private String originatingCountry;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Integer getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(Integer amountSell) {
		this.amountSell = amountSell;
	}

	public Integer getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(Integer amountBuy) {
		this.amountBuy = amountBuy;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public String getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
}
