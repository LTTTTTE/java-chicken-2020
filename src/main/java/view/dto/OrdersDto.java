package view.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Menu;

public class OrdersDto {
	private final List<OrderDto> orders;

	public OrdersDto(Map<Menu, Integer> orders) {
		this.orders = orders.entrySet()
			.stream()
			.map(x -> new OrderDto(x.getKey(), x.getValue()))
			.collect(Collectors.toList());
	}

	public List<OrderDto> getOrders() {
		return orders;
	}
}
