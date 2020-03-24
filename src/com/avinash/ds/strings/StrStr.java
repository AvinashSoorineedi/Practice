package com.avinash.ds.strings;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("b", "b"));
    }

    public static int strStr(final String A, final String B) {
        if (A != null && B != null) {
            int matchCount = 0;
            int startIndex = 0;
            for (int i = 0; i < A.length(); i++) {
                if (matchCount == B.length()) {
                    return startIndex;
                } else if (A.charAt(i) == B.charAt(0)) {
                    matchCount = 1;
                    startIndex = i;
                    int j = i+1;
                    int actualIndex = 1;
                    while (actualIndex < B.length() && j < A.length()) {
                        if (A.charAt(j) != B.charAt(actualIndex)) {
                            break;
                        } else {
                            matchCount++;
                            j++;
                            actualIndex++;
                        }
                    }
                } else {
                    matchCount = 0;
                }
            }
        }

        return -1;
    }

}
