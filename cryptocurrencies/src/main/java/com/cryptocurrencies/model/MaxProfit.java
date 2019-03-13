package com.cryptocurrencies.model;

import java.math.BigDecimal;

public class MaxProfit {

	private BigDecimal buyPrice;
	private String buyTime;
	private BigDecimal sellPrice;
	private String sellTime;
	private BigDecimal profit;

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellTime() {
		return sellTime;
	}

	public void setSellTime(String sellTime) {
		this.sellTime = sellTime;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public static final class MaxProfitBuilder {
		private BigDecimal buyPrice;
		private String buyTime;
		private BigDecimal sellPrice;
		private String sellTime;
		private BigDecimal profit;

		private MaxProfitBuilder() {
		}

		public static MaxProfitBuilder anMaxProfit() {
			return new MaxProfitBuilder();
		}

		public MaxProfitBuilder withBuyPrice(BigDecimal buyPrice) {
			this.buyPrice = buyPrice;
			return this;
		}

		public MaxProfitBuilder withBuyTime(String buyTime) {
			this.buyTime = buyTime;
			return this;
		}

		public MaxProfitBuilder withSellPrice(BigDecimal sellPrice) {
			this.sellPrice = sellPrice;
			return this;
		}

		public MaxProfitBuilder withSellTime(String sellTime) {
			this.sellTime = sellTime;
			return this;
		}

		public MaxProfitBuilder withProfit(BigDecimal profit) {
			this.profit = profit;
			return this;
		}

		public MaxProfit build() {
			MaxProfit maxProfit = new MaxProfit();
			maxProfit.setBuyPrice(buyPrice);
			maxProfit.setBuyTime(buyTime);
			maxProfit.setSellPrice(sellPrice);
			maxProfit.setSellTime(sellTime);
			maxProfit.setProfit(profit);
			return maxProfit;
		}
	}
}
