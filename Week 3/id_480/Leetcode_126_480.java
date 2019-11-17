//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法

import java.util.*;

public class Leetcode_126_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_126_480().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            // 如果不含有结束单词，直接结束，不然后边会造成死循环
            if (!wordList.contains(endWord)) {
                return ans;
            }
            bfs(beginWord, endWord, wordList, ans);
            return ans;
        }

        public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
            Queue<List<String>> queue = new LinkedList<>();
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            queue.offer(path);
            boolean isFound = false;
            Set<String> dict = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Set<String> subVisited = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    List<String> p = queue.poll();
                    //得到当前路径的末尾单词
                    String temp = p.get(p.size() - 1);
                    // 一次性得到所有的下一个的节点
                    ArrayList<String> neighbors = getNeighbors(temp, dict);
                    for (String neighbor : neighbors) {
                        //只考虑之前没有出现过的单词
                        if (!visited.contains(neighbor)) {
                            //到达结束单词
                            if (neighbor.equals(endWord)) {
                                isFound = true;
                                p.add(neighbor);
                                ans.add(new ArrayList<String>(p));
                                p.remove(p.size() - 1);
                            }
                            //加入当前单词
                            p.add(neighbor);
                            queue.offer(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                            subVisited.add(neighbor);
                        }
                    }
                }
                visited.addAll(subVisited);
                if (isFound) {
                    break;
                }
            }
        }

        private ArrayList<String> getNeighbors(String node, Set<String> dict) {
            ArrayList<String> res = new ArrayList<String>();
            char chs[] = node.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < chs.length; i++) {
                    if (chs[i] == ch)
                        continue;
                    char old_ch = chs[i];
                    chs[i] = ch;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = old_ch;
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}