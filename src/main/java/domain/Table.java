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
		orders.put(menu, count);
	}

	public Map<Menu, Integer> getOrders() {
		return orders;
	}

	public void deleteAllOrders() {
		orders = new HashMap<>();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
