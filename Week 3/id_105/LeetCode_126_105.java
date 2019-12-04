package id_105;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_126_105 {


    /**
     * 思路：使用BFS
     * 1）其他Queue里面存放的是下一个或者之后所需要计算的元素。
     *    本题Queue里面存放的是走过的路径。
     * 2）最短路径，所以需要一个min记录最小路径。
     * 3）Visited集合为本路径走过的Node的集合。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }

        Map<String, Set<String>> nodeDistance = new HashMap<>();
        for (String s : wordList) {
            nodeDistance.put(s, new HashSet<>());
        }

        Queue<List<String>> paths = new LinkedList<>();
        List<String> initPath = new ArrayList<>();
        initPath.add(beginWord);
        paths.add(initPath);

        int min = Integer.MAX_VALUE;
        while (!paths.isEmpty()) {
            int length = paths.size();
            for (int i = 0; i < length; i++) {
                List<String> path = paths.remove(); //cur path.
                String tail = path.get(path.size() - 1);
                List<String> nextCombos = getNextLevelCombos(tail, wordList, new HashSet<>(path));

                for (String nextCombo : nextCombos) {
                    if (nodeDistance.get(tail).contains(nextCombo)) {
                        continue;
                    }
                    nodeDistance.get(tail).add(nextCombo);
                    List<String> answer = new ArrayList<>(path);
                    answer.add(nextCombo);
                    if (nextCombo.equals(endWord) && answer.size() <= min) {
                        min = answer.size();
                        ans.add(answer);
                        break;
                    }
                    paths.add(answer);
                }
            }
        }

        return ans;
    }

    private List<String> getNextLevelCombos(String tail, List<String> list, Set<String> visited) {

        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(list);


        char[] chs = tail.toCharArray();
        String newStr = null;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                newStr = String.valueOf(chs);
                if (dict.contains(newStr) && !visited.contains(newStr)) {
                    result.add(newStr);
                }
                chs[i] = old_ch;
            }
        }


        return result;
    }

}
