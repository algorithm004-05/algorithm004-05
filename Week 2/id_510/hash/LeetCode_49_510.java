
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_49_510 {

    public static void main(String[] args) {
        String[] ss = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = new LeetCode_49_510().groupAnagrams1(ss);
        System.out.println(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (null == strs || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = encode(strs[i]);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        Iterator<List<String>> it = map.values().iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }

    private String encode(String str) {
        int[] s = new int[26];
        for (int i = 0; i < str.length(); i++) {
            s[str.charAt(i) - 'a']++;
        }
        return String.valueOf(s);
    }

    private String encode1(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    private int encode2(String str) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101 };
        int hash = 1;
        for (int i = 0; i < str.length(); i++) {
            hash *= primes[str.charAt(i) - 'a'];
        }
        return hash;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (null == strs || strs.length == 0) {
            return result;
        }
        int index = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = encode1(strs[i]);
            if (!map.containsKey(key)) {
                index++;
                List<String> l = new ArrayList<String>();
                result.add(l);
                map.put(key, index);
            }
            result.get(map.get(key)).add(strs[i]);
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (null == strs || strs.length == 0) {
            return result;
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = encode1(strs[i]);
            ArrayList<String> l = map.get(key);
            if (null == l) {
                map.put(key, l = new ArrayList<String>());
                result.add(l);

            }
            l.add(strs[i]);
        }
        return result;
    }
}
