import java.util.Arrays;

public class LeetCode_242_750 {


    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] str1 = t.toCharArray();
        char[] str2 = s.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int c:counter) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = LeetCode_242_750.isAnagram2(s, t);
        System.out.println(result);
    }

}
