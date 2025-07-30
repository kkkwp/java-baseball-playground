package study;

public class Calculator {

	public static int calculate(String value) {
		validateInput(value);

		String[] values = value.trim().split(" ");
		validateFormulaStructure(values);

		int result = validateInt(values[0]);
		for (int i = 1; i < values.length; i += 2) {
			String operator = values[i];
			int operand = validateInt(values[i + 1]);
			result = apply(result, operator, operand);
		}
		return result;
	}

	private static int apply(int a, String operator, int b) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				validateDivision(b);
				return a / b;
			default:
				validateOperator();
				return 0;
		}
	}

	private static void validateInput(String value) {
		if (value == null)
			throw new IllegalArgumentException("입력은 null일 수 없다.");
		if (value.trim().isEmpty())
			throw new IllegalArgumentException("입력은 공백이거나 빈 문자열일 수 없다.");
	}

	private static void validateFormulaStructure(String[] values) {
		if (values.length < 3)
			throw new IllegalArgumentException("수식이 너무 짧다.");
		if (values.length % 2 == 0)
			throw new IllegalArgumentException("올바르지 않은 수식이다.");
	}

	private static int validateInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("수식의 순서가 올바르지 않다.");
		}
	}

	private static void validateDivision(int b) {
		if (b == 0)
			throw new IllegalArgumentException("0으로 나눌 수 없다.");
	}

	private static void validateOperator() {
		throw new IllegalArgumentException("올바르지 않은 연산자다.");
	}
}

