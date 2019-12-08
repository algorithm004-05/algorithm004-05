
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_17_510 {

    public static void main(String[] args) {
        List<String> list = new LeetCode_17_510().letterCombinations1("0194");
        System.out.println(list);
    }
    /**
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(null == digits || 0 == digits.length()){
            return list;
        }

        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper("", digits, 0, map, list);
        return list;
    }

    /**
     * 类似树的深层遍历
     * @param s
     * @param digits
     * @param i
     * @param map
     * @param list
     */
    private void helper(String s,String digits,int i,Map<Character,String> map,List<String> list){
        if(i == digits.length()){
            list.add(s);
            return;
        }

        String temp  = map.get(digits.charAt(i));
        if(null != temp){
            for (int j = 0; j < temp.length(); j++) {
                 helper(s + temp.charAt(j), digits, i+1, map, list);
            } 
        } else {
            helper(s, digits, i+1, map, list);
        }
    }


    /**
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        if(null == digits || 0 == digits.length()){
            return list;
        }

        char[] cc = digits.toCharArray();
        String[] ss = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        int count = 0;
        for (int i = 0; i < cc.length; i++) {
            char[] temp = ss[Character.getNumericValue(cc[i])].toCharArray();
            if(null != temp && temp.length > 0){
                while(queue.peek().length() == (i-count)){
                    String row = queue.poll();
                    for (char l : temp) {
                        queue.offer(row + l);
                    }
                }
            } else {
                count++;
            }
        }
        list.addAll(queue);
        return list;
    }
}
