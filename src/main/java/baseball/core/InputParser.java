package baseball.core;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(ch - '0');
        }
        return numbers;
    }
}
