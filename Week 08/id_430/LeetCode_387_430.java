import java.util.HashMap;
import java.util.Map;

/**
 * Created by panda on 2019/12/8.
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_387_430 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                map.put(s.charAt(i), map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (map.get(c) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
