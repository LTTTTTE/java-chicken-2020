package view;

import java.util.List;

import domain.Menu;
import view.dto.OrderDto;
import view.dto.OrdersDto;
import view.dto.TableDto;
import view.dto.TablesDto;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_LINE = "- $ -";

	public static void printMainMenus() {
		System.out.println("## 메인화면\n"
			+ "1 - 주문등록\n"
			+ "2 - 결제하기\n"
			+ "3 - 프로그램 종료\n");
	}

	public static void printTables(final TablesDto tablesDto) {
		System.out.println("## 테이블 목록");
		List<TableDto> tables = tablesDto.getTables();
		printLine(TOP_LINE, tables);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, tables);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	public static void printOrders(final OrdersDto orders) {
		orders.getOrders()
			.forEach(OutputView::printSingleOrder);
	}

	public static void printBills(final double bills) {
		System.out.printf("## 최종 결제 할 금액 %.0f원\n", bills);
	}

	private static void printSingleOrder(final OrderDto orderDto) {
		System.out.println(orderDto.getMenuName() + " " + orderDto.getCount() + " : " + orderDto.getPrice());
	}

	private static void printLine(final String line, final List<TableDto> tables) {
		for (TableDto table : tables) {
			System.out.print(orderedString(line, table));
		}
		System.out.println();
	}

	private static String orderedString(String line, TableDto table) {
		if(table.isOrdered()) {
			return ORDERED_LINE;
		}
		return line;
	}

	private static void printTableNumbers(final List<TableDto> tables) {
		for (final TableDto table : tables) {
			System.out.printf(TABLE_FORMAT, table.getTableNumber());
		}
		System.out.println();
	}
}
