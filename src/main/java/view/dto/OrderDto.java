package view.dto;

import domain.Menu;

public class OrderDto {
	private String menuName;
	private int count;
	private int price;

	public OrderDto(Menu menu, int count) {
		this.menuName = menu.getName();
		this.count = count;
		this.price = menu.getPriceByMultiple(count);
	}

	public String getMenuName() {
		return menuName;
	}

	public int getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}
}
