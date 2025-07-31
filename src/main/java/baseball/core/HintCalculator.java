package baseball.core;

import java.util.List;

public class HintCalculator {
    
    public static Hint calculate(List<Integer> input, List<Integer> answer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < answer.size(); i++) {
            int number = input.get(i);
            if (answer.get(i) == number) {
                strikes++;
                continue;
            }
            if (answer.contains(number)) {
                balls++;
            }
        }
        return new Hint(strikes, balls);
    }
}
