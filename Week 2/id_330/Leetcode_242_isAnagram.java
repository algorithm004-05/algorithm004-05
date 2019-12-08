import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode_242_isAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */

    public static void main(String[] args) {

        String a = "abcd";
        String b = "dcaeb";
        boolean flag = isAnagram1(a, b);
        System.out.println(flag);

    }

    /**
     * 既然是异位词，排序之后是相同的字符串
     * 时间复杂度：O(nlog⁡n)O(n \log n)O(nlogn)，假设 nnn 是 sss 的长度，排序成本 O(nlog⁡n)O(n\log n)O(nlogn) 和比较两个字符串的成本 O(n)O(n)O(n)。排序时间占主导地位，总体时间复杂度为 O(nlog⁡n)O(n \log n)O(nlogn)。
     *
     */
    public static boolean isAnagram1(String s, String t) {
        if (s == null || s.equals(t)) {
            return false;
        }
        char[] sc1 = s.toCharArray();
        char[] sc2 = t.toCharArray();
        Arrays.sort(sc1);
        Arrays.sort(sc2);
        return Arrays.equals(sc1, sc2);
    }

    /**
     * 计算每一个字符出现的次数
     */
    public static boolean isAnagram2(String s, String t) {
        if (s == null || s.equals(t)) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < counter.length; i++) {
            // s中再出现的单词位置加1
            counter[s.charAt(i) - 'a']++ ;
            // t中出现的单词位置加1
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
           if (count != 0) {
               return false;
           }
        }
        return true;
    }
}
