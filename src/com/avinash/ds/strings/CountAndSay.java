package com.avinash.ds.strings;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

    public static String countAndSay(int A) {
        
        if(A==1) {
            return "1";
        }
        A = A-1;
        int index = 1;
        StringBuilder sb = new StringBuilder("11");
        while (index < A) {
            int count = 1;
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if (i == sb.length() - 1) {
                    temp.append(String.valueOf(count) + sb.charAt(i));
                } else {
                    if (sb.charAt(i) == sb.charAt(i + 1)) {
                        count++;
                        continue;
                    } else {
                        temp.append(String.valueOf(count) + sb.charAt(i));
                        count = 1;
                    }
                }
            }
            index++;
            sb = temp;
        }
        return sb.toString();
    }

}
