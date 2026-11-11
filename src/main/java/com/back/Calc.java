package com.back;

public class Calc {
    public static int run(String expression) {
        String[] bits = expression.split(" \\+ ");

        return Integer.parseInt(bits[0]) + Integer.parseInt(bits[1]);
    }
}
