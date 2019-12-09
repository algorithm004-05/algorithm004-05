package leetcode.editor.cn;  //给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode_212_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_212_480().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //leetcode submit region begin(Prohibit modification and deletion)
        public List<String> findWords(char[][] board, String[] words) {
            //构建字典树
            wordTrie myTrie = new wordTrie();
            trieNode root = myTrie.root;
            for (String s : words)
                myTrie.insert(s);

            //使用set防止重复
            Set<String> result = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            //遍历整个二维数组
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    find(board, visited, i, j, m, n, result, root);
                }
            }
            System.out.print(result);
            return new LinkedList<String>(result);
        }

        private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, trieNode cur) {
            //边界以及是否已经访问判断
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
                return;
            cur = cur.child[board[i][j] - 'a'];
            visited[i][j] = true;
            if (cur == null) {
                //如果单词不匹配，回退
                visited[i][j] = false;
                return;
            }
            //找到单词加入
            if (cur.isLeaf) {
                result.add(cur.val);
                //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
//            visited[i][j]=false;
//            return;
            }
            find(board, visited, i + 1, j, m, n, result, cur);
            find(board, visited, i, j + 1, m, n, result, cur);
            find(board, visited, i, j - 1, m, n, result, cur);
            find(board, visited, i - 1, j, m, n, result, cur);
            //最后要回退，因为下一个起点可能会用到上一个起点的字符
            visited[i][j] = false;
        }


    }

    //字典树
    class wordTrie {
        public trieNode root = new trieNode();

        public void insert(String s) {
            trieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new trieNode();
                    cur = cur.child[c - 'a'];
                } else
                    cur = cur.child[c - 'a'];
            }
            cur.isLeaf = true;
            cur.val = s;
        }
    }

    //字典树结点
    class trieNode {
        public String val;
        public trieNode[] child = new trieNode[26];
        public boolean isLeaf = false;

        trieNode() {

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

