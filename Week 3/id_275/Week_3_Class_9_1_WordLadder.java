//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

package leetcode.editor.cn;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：单词接龙
public class P3_C9_1_WordLadder {
    public static void main(String[] args) {
        Solution solution = new P3_C9_1_WordLadder().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> visited = new ArrayList<>();

    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length() || wordList.size() == 0) {
            return 0;
        }

        if (!wordList.contains(endWord)) return 0;

        Deque<Pair<Integer, String>> deque = new ArrayDeque();
        deque.add(new Pair<>(1, beginWord));
        visited.add(beginWord);
        return think(deque, endWord, wordList);
    }

    private int think(Deque<Pair<Integer, String>> deque, String endWord, List<String> wordList) {
        while (!deque.isEmpty()) {
            Pair<Integer, String> beginWord = deque.poll();
            String value = beginWord.snd;
            Integer currentLevel = beginWord.fst;
            if (value.equals(endWord)) {
                return currentLevel;
            }
            for (String word : wordList) {
                boolean canAdd = _compareStr(value, word, endWord) && !visited.contains(word);
                if (!canAdd) continue;
                visited.add(word);
                deque.add(new Pair<>(++currentLevel, word));
            }
        }
        return 0;
    }
}

    private boolean _compareStr(String beginWord, String word, String endWord) {
        char[] chars = beginWord.toCharArray();
        char[] chars1 = word.toCharArray();
        char[] chars2 = endWord.toCharArray();
        int e = 0;
        int e2 = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            char bChar = chars1[i];
            char cChar = chars2[i];
            if (aChar == bChar) {
                e++;
            }
            if (bChar == cChar) {
                e2++;
            }
        }
        return e == 2 && e2 > 0;
    }
//leetcode submit region end(Prohibit modification and deletion)

}