package view.dto;

public class TableDto {
	private int tableNumber;
	private boolean isOrdered;

	public TableDto(int tableNumber, boolean isOrdered) {
		this.tableNumber = tableNumber;
		this.isOrdered = isOrdered;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public boolean isOrdered() {
		return isOrdered;
	}
}
