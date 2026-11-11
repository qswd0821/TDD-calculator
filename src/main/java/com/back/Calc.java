package com.back;

public class Calc {
    public static int run(String expression) {
        expression = expression.trim();

        // 왼쪽부터 계산되도록 마지막 + / - 를 기준으로 나눈다.
        // "a - b - c" => run("a - b") - c
        int plusIndex = expression.lastIndexOf(" + ");
        int minusIndex = expression.lastIndexOf(" - ");
        int index = Math.max(plusIndex, minusIndex);

        if (index != -1) {
            int left = run(expression.substring(0, index));
            int right = run(expression.substring(index + 3));

            return index == plusIndex ? left + right : left - right;
        }

        return Integer.parseInt(expression);
    }
}
