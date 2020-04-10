package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private Map<Menu, Integer> orders;

	public Table(final int number) {
		this.number = number;
		this.orders = new HashMap<>();
	}

	public void addMenu(Menu menu, int count) {
		if (orders.containsKey(menu)) {
			orders.put(menu, orders.get(menu) + count);
			return;
		}
		orders.put(menu, count);
	}

	public boolean isSameTableNumber(int number) {
		return this.number == number;
	}

	public boolean isOrdered() {
		return !orders.isEmpty();
	}

	public Map<Menu, Integer> getOrders() {
		return orders;
	}

	public int getBills() {
		return orders.entrySet()
			.stream()
			.mapToInt(entry -> entry.getKey().getPriceByMultiple(entry.getValue()))
			.sum();
	}

	public void deleteAllOrders() {
		orders = new HashMap<>();
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
