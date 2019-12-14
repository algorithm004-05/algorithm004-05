import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.22 21:37
 * @Description:
 */
public class A242 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram3(s, t));
    }

    /**
     * 方法1：将字符串转成数组，并且排序
     * 如果完全一致则为异位词
     * 时间复杂度：？
     * 空间复杂度：O(2n)
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram1(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS, charsT);
    }

    /**
     * 使用HashMap进行处理
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * 效率极低
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram2(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        // 依次把数组元素放入Map中，遇到相同的值则+1
        for (char charS : s.toCharArray()) {
            if (map.containsKey(charS)) {
                map.put(charS, map.get(charS) + 1);
            } else {
                map.put(charS, 1);
            }
        }

        // 依次讲第二个字符串的值，从数组中减去相应数量，如果值为0，则remove
        for (char charT : t.toCharArray()) {

            if (map.containsKey(charT)) {
                int value = map.get(charT) - 1;
                if (value == 0) {
                    map.remove(charT);
                } else {
                    map.put(charT, value);
                }
            } else {
                map.put(charT, -1);
            }
        }

        // 最后判断map是否为空即可
        return map.isEmpty();
    }

    /**
     * 利用数组的方式，该方式跟hash类似。
     * 也同week1中的很多数据处理方式类似
     * 时间：O(n)
     * 空间：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram3(String s, String t) {

        int[] arr = new int[26];

        for (char sChar : s.toCharArray()) {
            arr[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            arr[tChar - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
















