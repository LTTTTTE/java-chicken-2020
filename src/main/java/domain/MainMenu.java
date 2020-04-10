package domain;

import java.util.Arrays;

public enum MainMenu {
	ORDER(1),
	PAY(2),
	END(3);

	private final int input;

	MainMenu(int input) {
		this.input = input;
	}

	public boolean isNotEnd(){
		return this != END;
	}

	public boolean isOrder() {
		return this == ORDER;
	}

	public boolean isPay() {
		return this == PAY;
	}

	public static MainMenu of(int input) {
		return Arrays.stream(MainMenu.values())
			.filter(x -> x.input == input)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));
	}
}
