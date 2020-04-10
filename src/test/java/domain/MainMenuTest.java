package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainMenuTest {
	@Test
	public void initTest() {
		MainMenu menu = MainMenu.of(1);

		assertThat(menu).isNotNull();
	}

	@Test
	public void isNotEndTest() {
		MainMenu menu = MainMenu.of(1);

		assertThat(menu.isNotEnd()).isTrue();
	}

	@Test
	public void isOrderTest() {
		MainMenu menu = MainMenu.of(1);

		assertThat(menu.isOrder()).isTrue();
	}

	@Test
	public void isPayTest() {
		MainMenu menu = MainMenu.of(2);

		assertThat(menu.isPay()).isTrue();
	}
}