package domain;

public class PaymentManager {
	private final Payment payment;
	private final int price;

	public PaymentManager(Payment payment, int price) {
		this.payment = payment;
		this.price = price;
	}

	public double calculate() {
		return payment.getDiscount(price);
	}
}
