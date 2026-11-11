package com.back;

public class Calc {
    public static int run(String expression) {
        expression = expression.trim();

        // 우선순위가 낮은 연산자(+, -)부터 나눠야 곱셈이 먼저 계산된다.
        // 왼쪽부터 계산되도록 마지막 연산자를 기준으로 나눈다.
        // 예) "a - b - c" => run("a - b") - run("c")
        int plusIndex = expression.lastIndexOf(" + ");
        int minusIndex = expression.lastIndexOf(" - ");
        int index = Math.max(plusIndex, minusIndex);

        if (index != -1) {
            int left = run(expression.substring(0, index));
            int right = run(expression.substring(index + 3));

            return index == plusIndex ? left + right : left - right;
        }

        int multiplyIndex = expression.lastIndexOf(" * ");

        if (multiplyIndex != -1) {
            int left = run(expression.substring(0, multiplyIndex));
            int right = run(expression.substring(multiplyIndex + 3));

            return left * right;
        }

        // 연산자가 없으면 숫자 하나 ("-10" 같은 음수 포함)
        return Integer.parseInt(expression);
    }
}
