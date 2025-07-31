package baseball.core;

public class InputValidator {

    public static void validateNumbers(String input) {

        //  null 또는 공백 검증
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        //  숫자만 포함되었는지 검증
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
        }
        // 길이 검증
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        // 각 숫자가 1~9 범위인지 검증
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력할 수 있습니다.");
        }
        // 중복 검증
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public static void validateRestartNumbers(String input) {
        // 1 또는 2가 입력되었는지 검증
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다. 다시 입력해주세요.");
        }
    }

}
