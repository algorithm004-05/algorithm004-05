package lesson.week.two;

/**
 * Created by liangwj20 on 2019/10/27 17:11
 * Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class LeetCode_242_320 {

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "bca") );
    }

    /**
     * 判断t是否s的字母异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null | s.length() == 0 || s.length() != t.length()) {
            return false;
        }

        int[] alphas = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i) - 'a']++;
            alphas[t.charAt(i) - 'a']--;
        }
        for (int alpha : alphas) {
            if (alpha != 0) {
                return false;
            }
        }
        return true;
    }

}
