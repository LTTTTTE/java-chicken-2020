package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

	@Test
	public void initTest() {
		Payment paymentType = Payment.of(1);

		assertThat(paymentType).isEqualTo(Payment.CARD);
	}

	@Test
	@DisplayName("카드로 결제 받으면 할인 못받는다")
	public void cardDiscountTest() {
		Payment card = Payment.CARD;
		int bills = 10_000;

		assertThat(card.getDiscount(bills)).isEqualTo(10_000);
	}

	@Test
	@DisplayName("현금으로 결제 받으면 할인 받을수 있다.")
	public void cashDiscountTest() {
		Payment cash = Payment.CASH;
		int bills = 10_000;

		assertThat(cash.getDiscount(bills)).isEqualTo(9_500);
	}

}