package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
		Table table = tables.get(tableNumber);
		if (Objects.isNull(table)) {
			throw new IllegalArgumentException("존재하지 않는 테이블 번호 입니다.");
		}
		return table;
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}
}
