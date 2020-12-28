package Calculator;

import java.util.Scanner;

public class Calculator {

    // 1. 문자열 입력
    static String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    // 2. 입력값 공백/null 체크
    static boolean isBlank(String input) {
        if (input == null ||input.equals(" ") || input.isEmpty()) {
            throw new IllegalArgumentException("IllegalArgumentException !!!");
        }
        return false;
    }

    // 2-1. 입력값 공백 기준으로 split
    static String[] splitBlank(String input) {
        return input.split(" ");
    }

    // 3. 입력 값 실행
    static int makeResult(String input) {
        if (isBlank(input))
            throw new IllegalArgumentException("IllegalArgumentException !!!");
        return calculateSplitedString(splitBlank(input));
    }

    // 4. 입력 값 계산 실행
    static int calculateSplitedString(String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    static int calculate(int first, char operator, int second) {
        if (operator == '+')
            return addition(first, second);
        if (operator == '-')
            return subtraction(first, second);
        if (operator == '*')
            return multiplication(first, second);
        if (operator == '/')
            return division(first, second);
        throw new IllegalArgumentException("IllegalArgumentException !!!");
    }

    static int addition(int i, int j) {
        return i + j;
    }

    static int subtraction(int i, int j) {
        return i - j;
    }

    static int multiplication(int i, int j) {
        return i * j;
    }

    static int division(int i, int j) {
        return i / j;
    }

    static int toInt(String str) {
        return Integer.parseInt(str);
    }

}
