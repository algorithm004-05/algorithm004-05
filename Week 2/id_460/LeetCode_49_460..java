package week2.Lesson5.Qusestion49GroupAnagrams;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] in = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams1(in);
        groupAnagrams2(in);
    }

    private static ArrayList<String> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, ArrayList<String>> result = new HashMap();
        for (String s : strs) {
            char[] ar = s.toCharArray();//把s分解成字符数组
            Arrays.sort(ar);//对字符数组进行排序
            String key = ar.toString();//用排完序以后的字符串做key；
            if (!result.containsKey(key)) result.put(key, new ArrayList());//有新的key的时候，把key put进入map
            result.get(key).add(s);//给对应的key设置value；
        }
        return new ArrayList(result.values());
    }

    //按计数分类
    private static ArrayList<String> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, ArrayList<String>> result = new HashMap();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!result.containsKey(key)) result.put(key, new ArrayList());
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }

}




















