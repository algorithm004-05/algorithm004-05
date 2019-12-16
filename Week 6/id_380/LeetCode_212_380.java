//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word: words)
            trie.insert(word);

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> resultSet = new HashSet();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                search(board, visited, i, j, m, n, trie.root, resultSet);
        }

        return new LinkedList<String>(resultSet);
    }


    private void search(char[][] board, boolean[][] visited, int i, int j, int m, int n, TrieNode node, Set<String> result) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j])
            return;

        node = node.children[board[i][j] - 'a'];
        if (node == null)
            return;

        if (node.word != null)
            result.add(node.word);

        visited[i][j] = true;
        search(board, visited, i-1, j, m, n, node, result);
        search(board, visited, i+1, j, m, n, node, result);
        search(board, visited, i, j-1, m, n, node, result);
        search(board, visited, i, j+1, m, n, node, result);
        visited[i][j] = false;
    }
}

class Trie {
    public TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        int n = word.length();
        int charNo;
        for (int i = 0; i < n; ++i) {
            charNo = word.charAt(i) - 'a';
            if (node.children[charNo] == null)
                node.children[charNo] = new TrieNode();
            node = node.children[charNo];
        }
        node.word = word;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = null;
}

//leetcode submit region end(Prohibit modification and deletion)
