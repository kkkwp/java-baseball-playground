package baseball.view;

import baseball.core.Hint;

public class ResultView {

    public static void printHint(Hint hint) {
        int strikes = hint.getStrikes();
        int balls = hint.getBalls();

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (balls > 0 && strikes > 0) {
            sb.append(balls).append("볼 ").append(strikes).append("스트라이크");
            System.out.println(sb);
            return;
        }

        if (balls > 0) {
            sb.append(balls).append("볼");
            System.out.println(sb);
            return;
        }

        sb.append(strikes).append("스트라이크");
        System.out.println(sb);
    }

    public static void printGameEndPrompt() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
