package domain;

import java.util.Arrays;
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

	public static Payment of(int paymentTypeInput) {
		return Arrays.stream(Payment.values())
			.filter(x -> x.paymentTypeInput == paymentTypeInput)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("그런 결제방법은 없습니다."));
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
