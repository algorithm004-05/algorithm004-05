import java.util.*;
/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class LeetCode_212_100 {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    //利用字典树进行实现
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        //将单词存储至字典树中
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        TrieNode root = trie.root;
        //遍历 board进行DFS
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                dfs(x, y, board, root, "", set);
            }
        }
        return new ArrayList<>(set);
    }


    private void dfs(int x, int y, char[][] board, TrieNode root, String word, Set<String> ans) {
        //边界条件判定
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return;
        }
        //当前层逻辑
        char c = board[x][y];
        if (c == '.') {
            return;
        }
        int index = c - 'a';
        root = root.children[index];
        if (root == null) {
            return;
        }
        word += c;
        if (root.isEnd) {
            ans.add(word);
        }
        //标识当前结点访问过了
        board[x][y] = '.';
        //下探
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], board, root, word, ans);
        }
        //清除状态
        board[x][y] = c;
    }




    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode('/');
        }

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode(c);
                }
                p = p.children[index];
            }
            p.isEnd = true;
        }
    }



    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        TrieNode(char data) {
            this.data = data;
        }
    }
}