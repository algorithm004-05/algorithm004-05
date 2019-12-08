//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList();
        }
        Map<Character, String> phone = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new LinkedList<String>();
        search("", digits, 0, res, phone);
        return res;
    }

    private void search(String s, String digits, int i, List<String> res, Map<Character, String> map){
        // 1. 函数的终结方式,避免死循环
        if (i == digits.length()){
            res.add(s);
            return;
        }
        // 2. 函数处理当前层
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++){
            // 3. 重复调用自身
            search(s + letters.charAt(j), digits, i + 1, res, map);
        }

        // 4. 子问题结果处理,并返回
    }
}
//leetcode submit region end(Prohibit modification and deletion)
