package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 크기를 확인한다.")
	@Test
	void size() {
		int given = numbers.size();
		assertThat(given).isEqualTo(3);
	}

	@DisplayName("1, 2, 3의 값이 존재하는지를 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains1(int value) {
		// assertThat(numbers.contains(1)).isTrue();
		// assertThat(numbers.contains(2)).isTrue();
		// assertThat(numbers.contains(3)).isTrue();
		assertTrue(numbers.contains(value));
	}

	@DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false가 반환된다.")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains2(int input, boolean expected) {
		assertEquals(expected, numbers.contains(input));
	}

}
