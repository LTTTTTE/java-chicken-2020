package domain;

import java.util.Map;

public class Table {
	private final int number;
	private final Orders orders;

	public Table(final int number) {
		this.number = number;
		this.orders = new Orders();
	}

	public void addMenu(Menu menu, int count) {
		orders.putOrder(menu, count);
	}

	public boolean isSameTableNumber(int number) {
		return this.number == number;
	}

	public boolean isOrdered() {
		return orders.isOrdered();
	}

	public int getBills() {
		return orders.getBills();
	}

	public void deleteAllOrders() {
		orders.deleteAllOrders();
	}

	public Map<Menu, Integer> getOrders() {
		return orders.getOrders();
	}

	public int getNumber() {
		return number;
	}
}
