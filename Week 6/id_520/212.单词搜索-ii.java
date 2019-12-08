import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        TrieNode root1 = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0 ; j < board[0].length; j++) {
                dfs(board,i,j,root1,result);
            }
        }
        return result;
    }

    //相当于208题中的 insert
    public TrieNode buildTrie(String[] words) {
        //和208不同，这里每一个测试用例都需要单独建立一个Trie，208建立起来一个
        //然后被别的程序调用
        TrieNode root = new TrieNode();
        for (String s1 : words) {
            // root不能动，创建Trie的过程每次用node表示当前节点
            TrieNode node = root;
            for (char c : s1.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.word = s1;// Store a word at the leaf node
        }
        return root;
    }

    //DFS
    public void dfs(char[][] board, int i, int j, TrieNode node, 
                    List<String> result) {
        char c = board[i][j];
        // terminator
        if (c == '#' || node.children[c - 'a'] == null) return;

        // process current logic
        node = node.children[c - 'a'];
        if (node.word != null) {  // found one
            result.add(node.word);
            node.word = null;   //de-duplicate
        }
        // '#' marked cell has been visited
        board[i][j] = '#';
        //left
        if (i > 0) dfs(board, i-1, j, node, result);
        //up
        if (j > 0) dfs(board, i, j-1, node, result);
        //right
        if (i < board.length - 1) dfs(board,i+1, j, node, result);
        //down
        if (j < board[0].length - 1) dfs(board,i, j+1, node, result);
        board[i][j] = c;
    }
}
// @lc code=end

