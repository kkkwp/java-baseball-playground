package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리된다.")
	@Test
	void split1() {
		String given = "1,2";
		String[] actual = given.split(",");
		assertThat(actual).contains("1", "2");
	}

	@DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
	@Test
	void split2() {
		String given = "1";
		String[] actual = given.split(",");
		assertThat(actual).containsExactly("1");
	}

	@DisplayName("\"(1,2)\" 값이 주어졌을 때 ()을 제거하고 \"1,2\"를 반환한다.")
	@Test
	void substring() {
		String given = "(1,2)";
		String actual = given.substring(1, given.length() - 1);
		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("\"abc\" 값이 주어졌을 때 특정 위치의 문자를 가져온다.")
	@Test
	void charAt_success() {
		String given = "abc";
		assertThat(given.charAt(0)).isEqualTo('a');
	}

	@DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
	@Test
	void charAt_fail_StringIndexOutOfBoundsException() {
		String given = "abc";
		assertThatThrownBy(() -> given.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
