package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PaymentManagerTest {
	@Test
	public void initTest() {
		PaymentManager paymentManager = new PaymentManager(Payment.CASH, 50_000);

		assertThat(paymentManager).isNotNull();
	}

	@Test
	public void calculateTest() {
		PaymentManager paymentManager = new PaymentManager(Payment.CASH, 50_000);

		double calculatedBills = paymentManager.calculate();

		assertThat(calculatedBills).isEqualTo(47_500);
	}
}