package week2.Lesson5.Question242IsAnagram;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * */

public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram1(s,t));
        System.out.println(isAnagram2(s,t));
    }
//    为了检查 t 是否是 s的重新排列，
//    我们可以计算两个字符串中每个字母的出现次数并进行比较。
//    因为 S 和 T 都只包含 A-Z 的字母，所以一个简单的 26 位计数器表就足够了。
//    我们需要两个计数器数表进行比较吗？
//    实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，
//    用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。

    private static boolean isAnagram1(String s, String t) {
        if (s.length()!=t.length())return false;
        int []counter = new int[26];
        for (int i=0;i<s.length();i++){
            counter[s.charAt(i) -'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for (int count:counter){
            if (count!=0) return false;
        }

        return true;
    }
    /**
     * 或者我们可以先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。
     * 如果在任何时候计数器低于零，我们知道 t 包含一个不在 s中的额外字母，并立即返回 FALSE
     */

    private static boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length())return false;
        int []counter = new int[26];
        for (int i=0;i<s.length();i++){
            counter[s.charAt(i) -'a']++;
        }
        for (int i=0;i<t.length();i++){
            counter[t.charAt(i) -'a']--;
            if (counter[t.charAt(i) -'a']<0){
                return false;
            }
        }
        return true;
    }
}






















