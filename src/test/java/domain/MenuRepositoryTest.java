package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuRepositoryTest {
	@Test
	@DisplayName("메뉴레포지토리에 있는 메뉴번호를 불러옴")
	public void getMenuTest() {
		Menu menu = MenuRepository.getMenu(1);

		assertThat(menu).isNotNull();
	}

	@Test
	@DisplayName("메뉴레포지토리에 없는 메뉴번호를 불러옴")
	public void getInvalidMenuTest() {
		assertThatThrownBy(() -> MenuRepository.getMenu(12345))
			.isInstanceOf(IllegalArgumentException.class);
	}
}