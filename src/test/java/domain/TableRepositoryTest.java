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
}