package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static Table findTable(int tableNumber) {
		return tables.stream()
			.filter(table -> table.isSameTableNumber(tableNumber))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블 번호입니다."));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}
}
