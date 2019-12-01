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
    private int[] x = {-1, 0, 1, 0};// 上右下左
    private int[] y = {0, 1, 0, -1};
    private Set<String> result = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || board == null || board.length == 0) {
            return new ArrayList<String>();
        }
        //先将words中的单词存入字典树中
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        TrieNode root = trie.root;
        //查找二维网络
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                find(i, j, board, visited, root);
            }
        }
        return new ArrayList<String>(result);
    }
    private void find (int i, int j, char[][] board, boolean[][] visited, TrieNode root) {
        int row = board.length;
        int column = board[0].length;
        if (i < 0 || j < 0 || i >= row || j >= column || visited[i][j]) {
            return;
        }
        visited[i][j] = true;// 以访问
        root = root.get(board[i][j]);
        if (root == null) {
            visited[i][j] = false;
            return;
        }
        if (root.isEnd()) {
            result.add(root.getWord());
        }
        for (int k = 0; k < 4; k++) {
            int r = i + x[k];
            int c = j + y[k];
            find(r, c, board, visited, root);
        }
        visited[i][j] = false;
    }
}
class Trie {
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
        node.setWord(word);
    }

    private TrieNode prefixSearch (String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }
}
class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private String word;
    private boolean isEnd;
    public TrieNode () {
        links = new TrieNode[R];
    }
    public boolean containsKey (char c) {
        return links[c - 'a'] != null;
    }
    public TrieNode get (char c) {
        return links[c - 'a'];
    }
    public void put (char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    public void setEnd () {
        isEnd = true;
    }
    public boolean isEnd () {
        return isEnd;
    }
    public String getWord () {
        return word;
    }
    public void setWord (String word) {
        this.word = word;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
