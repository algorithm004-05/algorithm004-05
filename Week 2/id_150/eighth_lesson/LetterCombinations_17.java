package com.geek.lee.leetcode.medium;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations_17 {
    Map<String, String> dict = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits)) {
            return res;
        }

        /**
         * 1. 回溯法
         */
        backtrack("", digits);
        return res;
    }

    private void backtrack(String s, String digits) {
        if (null == digits || digits.length() == 0) {
            res.add(s);
            return;
        }

        // 获取输入数字的第一位
        String cur = digits.substring(0, 1);
        // 获取数字对应的字母集
        String words = dict.get(cur);
        for (int i = 0; i < words.length(); i ++) {
            backtrack(s + words.substring(i, i + 1), digits.substring(1));
        }
    }

    public static void main(String[] args) {
        new LetterCombinations_17().letterCombinations("23");
    }
}
