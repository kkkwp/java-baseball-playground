package baseball;

import baseball.core.Hint;
import baseball.core.HintCalculator;
import baseball.core.InputParser;
import baseball.core.InputValidator;
import baseball.core.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        do {
            playGame();
        } while (restartGame());
    }

    static void playGame() {
        List<Integer> answer = RandomNumberGenerator.generate();
        Hint hint;

        do {
            String input = InputView.readInput();
            InputValidator.validateNumbers(input);
            List<Integer> numbers = InputParser.parse(input);

            hint = HintCalculator.calculate(numbers, answer);
            ResultView.printHint(hint);
        } while (hint.getStrikes() < 3);

        ResultView.printGameEndPrompt();
    }

    static boolean restartGame() {
        String input = InputView.readInput();
        InputValidator.validateRestartNumbers(input);
        return input.equals("1");
    }
}
