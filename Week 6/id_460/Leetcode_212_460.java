package week6.Question212FindWords;

import week6.Question208BuildTrie.Trie;
import week6.Question208BuildTrie.TrieNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords {
    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> wordsResult = findWords(board,words);
        System.out.println(wordsResult);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        Trie trie = new Trie();
        TrieNode root = trie.getRoot();
        for (String word : words) {
            trie.insert(word);
        }
        //使用set保存结果，防止重复
        Set<String> result = new HashSet<>();
        int m = board.length;//行
        int n = board[0].length;//列
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return new LinkedList<>(result);
    }

    private static void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode cur) {
        //边界以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            //超出了边界或者当前节点已经被访问过了
            return;
        }
        cur = cur.getLinks()[board[i][j] - 'a'];
        visited[i][j] = true;
        if (cur == null) {
            //单词不匹配，回退
            visited[i][j] = false;
            return;
        }
        if (cur.isEnd()) {
            //找到单词，加入set
            result.add(cur.getVal());
        }
        find(board, visited, i + 1, j, m, n, result, cur);//向右查找
        find(board, visited, i, j + 1, m, n, result, cur);//向下查找
        find(board, visited, i, j - 1, m, n, result, cur);//向上查找
        find(board, visited, i - 1, j, m, n, result, cur);//向左查找
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }
}
