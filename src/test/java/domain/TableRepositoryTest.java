package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TableRepositoryTest {
	@Test
	@DisplayName("존재하는 테이블 번호 접근할때")
	public void findTableTest() {
		Table table = TableRepository.findTable(1);

		assertThat(table).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(ints = {7, 10, 34})
	@DisplayName("존재하지 않는 테이블 번호 접근할때")
	public void findInvalidTableTest(int number) {
		assertThatThrownBy(() -> TableRepository.findTable(number))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("테이블에 메뉴추가하는 기능 테스트 (두번호출로 이전메뉴 저장여부까지 확인)")
	public void addMenuTest() {
		Table table = TableRepository.findTable(1);
		Menu menu = MenuRepository.getMenu(1);
		table.addMenu(menu, 10);
		table.addMenu(menu, 10);

		assertThat(table.getOrders().get(menu)).isEqualTo(20);
	}
}