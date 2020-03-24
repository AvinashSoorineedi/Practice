package com.avinash.ds.strings;

public class AToi {

    public static void main(String[] args) {
        System.out.println(atoi("-54332872018247709407 4 54"));
    }

    public static int atoi(final String A) {
        if (A.length() > 0) {
            String B = A.trim();
            boolean negative = false;
            boolean started = false;
            double value = 0;

            for (int i = 0; i < B.length(); i++) {
                if (!started && (B.charAt(i) == '+' || B.charAt(i) == '-')) {
                    negative = (B.charAt(i) == '-');
                } else if (Character.isDigit(B.charAt(i))) {
                    started = true;
                    value = value * 10 + (B.charAt(i) - '0');
                } else {
                    break;
                }
            }

            if (negative) {
                value = -value;
            }

            if (value > Integer.MAX_VALUE) {
                value = Integer.MAX_VALUE;
            } else if (value < Integer.MIN_VALUE) {
                value = Integer.MIN_VALUE;
            }
            return (int) value;
        }

        return 0;
    }
}
