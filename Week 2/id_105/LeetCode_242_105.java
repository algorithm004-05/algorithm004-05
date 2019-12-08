package id_105;

import java.util.Arrays;

public class LeetCode_242_105 {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        String sN = sort(s);
        String tN = sort(t);
        return sN.equals(tN);

    }

    private String sort(String s) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        return new String(sc);
    }
}
