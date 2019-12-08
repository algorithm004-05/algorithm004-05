package com.company;

public class LeetCode_8_540 {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        int begin = 0;
        int sign = 1;

        if (str.charAt(0) == '+') {
            begin++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            begin++;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }

        while (begin < str.length() && str.charAt(begin) == '0') {
            begin++;
        }

        int end = begin;
        while (end < str.length() && str.charAt(end) >= '0' && str.charAt(end) <= '9') {
            end ++;
        }

        if (end == begin) {
            return 0;
        }

        if (end - begin > 10) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (end - begin == 10) {
            long longValue = Long.valueOf(str.substring(begin, end));
            if (sign > 0 && longValue >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign < 0 && longValue*sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return Integer.valueOf(str.substring(begin, end)) * sign;
    }
}
