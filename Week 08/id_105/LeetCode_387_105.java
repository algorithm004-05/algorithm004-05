import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_387_105 {


    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int min = Integer.MAX_VALUE;
        s = s.toLowerCase();
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                min = Math.min(min, index);
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public int firstUniqChar2(String s) {

        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        LeetCode_387_105 l = new LeetCode_387_105();
        int i = l.firstUniqChar("LeetCode");
        System.out.println(i);

        System.out.println(l.firstUniqChar("loveleetcode"));
        System.out.println(l.firstUniqChar("aadadaad"));
    }


}
