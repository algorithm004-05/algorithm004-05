import java.util.HashMap;
import java.util.Map;

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
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_242_510 {

    /**
     *  map 计数
     * @param s
     * @param t
     * @return
     */

     public static void main(String[] args) {
         //String s = "anagram",t="nagaram";
         String s = "rat", t = "car";
        boolean flag = new LeetCode_242_510().isAnagram2(s, t);
         System.out.println(flag);
     }

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        if(null ==  s || null == t){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)){
                int size = map.get(c)-1;
                if (0 == size){
                    map.remove(c);
                } else {
                    map.put(c, size);
                }
            } else{
                return false;
            }
        }

        if(0 == map.size()){
            return true;
        }

        return false;
    }

   /**
     * 数组位计数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(null ==  s || null == t){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
   
        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            if(0 != table[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * 数组位计数 优化
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(null ==  s || null == t){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
   
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < table.length; i++) {
            if(0 != table[i]){
                return false;
            }
        }

        return true;
    }

}
