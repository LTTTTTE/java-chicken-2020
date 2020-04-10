package domain;

import java.util.function.Function;

public enum Payment {
	CARD(1, (value) -> value * 1.0),
	CASH(2, (value) -> value * 0.95);

	private final int paymentTypeInput;
	private final Function<Double, Double> discount;

	Payment(int paymentTypeInput, Function<Double, Double> discount) {
		this.paymentTypeInput = paymentTypeInput;
		this.discount = discount;
	}

	public boolean isCard() {
		return this == CARD;
	}

	public boolean isCash() {
		return this == CASH;
	}

	public double getDiscount(double value) {
		return discount.apply(value);
	}
}
