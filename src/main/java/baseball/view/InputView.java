package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return SCANNER.nextLine();
    }
}
