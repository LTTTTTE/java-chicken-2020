package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {
	Table table;

	@BeforeEach
	public void initTable() {
		int tableNumber = 1;
		table = TableRepository.findTable(tableNumber);
	}

	@AfterEach
	public void cleanUp() {
		table.deleteAllOrders();
	}

	@Test
	@DisplayName("테이블에 메뉴추가하는 기능 테스트 (두번호출로 이전메뉴 저장여부까지 확인)")
	public void addMenuTest() {
		Menu menu = MenuRepository.getMenu(1);
		table.addMenu(menu, 10);
		table.addMenu(menu, 10);

		assertThat(table.getOrders().get(menu)).isEqualTo(20);
	}

	@Test
	public void isSameTableNumberTest() {
		assertThat(table.isSameTableNumber(1)).isTrue();
	}

	@Test
	public void isOrderedTest() {
		table.addMenu(MenuRepository.getMenu(1), 5);

		assertThat(table.isOrdered()).isTrue();
	}

	@Test
	public void isNotOrderedTest() {
		assertThat(table.isOrdered()).isFalse();
	}

	@Test
	public void getBillsTest() {
		table.addMenu(MenuRepository.getMenu(1), 5);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 5);
	}

	@Test
	@DisplayName("같은치킨 10개 할인 적용여부 테스")
	public void chickenDiscountedBillTest() {
		table.addMenu(MenuRepository.getMenu(1), 10);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 10 - 10000);
	}

	@Test
	@DisplayName("치킨류 10개 할인 적용여부 테스")
	public void chickenTypeDiscountedBillTest() {
		table.addMenu(MenuRepository.getMenu(1), 5);
		table.addMenu(MenuRepository.getMenu(2), 5);

		int bills = table.getBills();

		assertThat(bills).isEqualTo(16000 * 10 - 10000);
	}

	@Test
	public void deleteAllOrdersTest() {
		table.addMenu(MenuRepository.getMenu(1), 5);

		table.deleteAllOrders();

		assertThat(!table.isOrdered()).isTrue();
	}

	@Test
	public void getOrdersTest() {
		assertThat(table.getOrders()).isInstanceOf(HashMap.class);
	}

	@Test
	public void getNumberTest() {
		assertThat(table.getNumber()).isInstanceOf(Integer.class);
	}
}