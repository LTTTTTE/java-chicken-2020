package domain;

import java.util.HashMap;
import java.util.Map;

public class Orders {
	private final Map<Menu, Integer> orders;

	public Orders() {
		this.orders = new HashMap<>();
	}

	public void putOrder(Menu menu, int count) {
		if (orders.containsKey(menu)) {
			orders.put(menu, orders.get(menu) + count);
			return;
		}
		orders.put(menu, count);
	}

	public boolean isOrdered() {
		return !orders.isEmpty();
	}

	public Map<Menu, Integer> getOrders() {
		return orders;
	}

	public void deleteAllOrders() {
		orders.clear();
	}

	public int getBills() {
		return orders.entrySet()
			.stream()
			.mapToInt(entry -> entry.getKey().getPriceByMultiple(entry.getValue()))
			.sum();
	}
}
