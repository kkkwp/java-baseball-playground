package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	@DisplayName("문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. ")
	@Test
	void calculate_success() {
		String input = "2 + 3 * 4 / 2";
		int actual = Calculator.calculate(input);
		assertThat(actual).isEqualTo(10);
	}

	@DisplayName("입력이 앞뒤 공백을 포함해도 정상 동작한다.")
	@Test
	void calculate_shouldTrimInput() {
		String input = " 2 + 3 * 4 / 2  ";
		int actual = Calculator.calculate(input);
		assertThat(actual).isEqualTo(10);
	}

	@DisplayName("입력이 null, 공백, 빈 문자열이면 IllegalArgumentException을 반환한다.")
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", " "})
	void calculate_shouldThrowExceptionForInvalidString(String input) {
		assertThatThrownBy(() -> Calculator.calculate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력은 ");
	}

	@DisplayName("수식이 올바르지 않은 경우 IllegalArgumentException을 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2 3", "2 +", "+ + 3", "3 + +"})
	void calculate_shouldThrowExceptionWhenOperatorIsMissing(String input) {
		assertThatThrownBy(() -> Calculator.calculate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("수식");
	}

	@DisplayName("연산자가 사칙연산이 아닌 경우 IllegalArgumentException을 반환한다.")
	@Test
	void calculate_shouldThrowExceptionForInvalidOperator() {
		String input = "3 % 4";
		assertThatThrownBy(() -> Calculator.calculate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("올바르지 않은 연산자다.");
	}

	@DisplayName("0으로 나누려는 경우 IllegalArgumentException를 반환한다.")
	@Test
	void calculate_shouldThrowExceptionForZero() {
		String input = "3 / 0";
		assertThatThrownBy(() -> Calculator.calculate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0으로 나눌 수 없다");
	}
}
