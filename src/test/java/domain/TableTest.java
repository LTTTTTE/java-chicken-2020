package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {

	@Test
	@DisplayName("테이블에 메뉴추가하는 기능 테스트 (두번호출로 이전메뉴 저장여부까지 확인)")
	public void addMenuTest() {
		Table table = TableRepository.findTable(1);
		Menu menu = MenuRepository.getMenu(1);
		table.addMenu(menu, 10);
		table.addMenu(menu, 10);

		assertThat(table.getOrders().get(menu)).isEqualTo(20);
	}

	@Test
	public void isSameTableNumberTest() {
		int tableNumber = 1;
		Table table = TableRepository.findTable(tableNumber);

		assertThat(table.isSameTableNumber(tableNumber)).isTrue();
	}

	@Test
	public void isOrderedTest() {
		Table table = TableRepository.findTable(2);
		table.addMenu(MenuRepository.getMenu(1), 5);

		assertThat(table.isOrdered()).isTrue();
	}

	@Test
	public void isNotOrderedTest() {
		Table table = TableRepository.findTable(3);

		assertThat(table.isOrdered()).isFalse();
	}

	@Test
	public void getBillsTest() {
		Table table = TableRepository.findTable(5);
		table.addMenu(MenuRepository.getMenu(1), 5);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 5);
	}

	@Test
	@DisplayName("같은치킨 10개 할인 적용여부 테스")
	public void chickenDiscountedBillTest() {
		Table table = TableRepository.findTable(6);
		table.addMenu(MenuRepository.getMenu(1), 10);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 10 - 10000);
	}

	@Test
	@DisplayName("치킨류 10개 할인 적용여부 테스")
	public void chickenTypeDiscountedBillTest() {
		Table table = TableRepository.findTable(8);
		table.addMenu(MenuRepository.getMenu(1), 5);
		table.addMenu(MenuRepository.getMenu(2), 5);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 10 - 10000);
	}

	@Test
	public void deleteAllOrdersTest() {
		Table table = TableRepository.findTable(1);
		table.addMenu(MenuRepository.getMenu(1), 5);

		table.deleteAllOrders();

		assertThat(!table.isOrdered()).isTrue();
	}

	@Test
	public void getOrdersTest() {
		Table table = TableRepository.findTable(1);

		assertThat(table.getOrders()).isInstanceOf(HashMap.class);
	}

	@Test
	public void getNumberTest() {
		Table table = TableRepository.findTable(1);

		assertThat(table.getNumber()).isInstanceOf(Integer.class);
	}
}