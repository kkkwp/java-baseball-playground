package study;

import static study.Calculator.*;

import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		System.out.println(calculate(value));
	}
}
