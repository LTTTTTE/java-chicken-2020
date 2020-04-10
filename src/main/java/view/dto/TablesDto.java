package view.dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.Table;

public class TablesDto {
	private final List<TableDto> tables;

	public TablesDto(List<Table> tables) {
		this.tables = tables.stream()
			.map(table -> new TableDto(table.getNumber(), table.isOrdered()))
			.collect(Collectors.toList());
	}

	public List<TableDto> getTables() {
		return tables;
	}
}
