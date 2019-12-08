package leetcode.jacf.tech;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * @author jacf
 */
public class WordSearchII {
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            // trie
            Trie wordDic = new Trie();
            for (String word : words) {
                wordDic.insert(word);
            }

            Set<String> result = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    find(board, visited, i, j, m, n, result, wordDic.root);
                }
            }

            return new LinkedList<>(result);
        }

        public void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode node) {
            // everything should be in the region
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
                return;
            }
            node = node.links[board[i][j] - 'a'];
            visited[i][j] = true;
            if (node == null) {
                visited[i][j] = false;
                return;
            }

            if (node.isEnd) {
                result.add(node.val);
            }

            find(board, visited, i + 1, j, m, n, result, node);
            find(board, visited, i - 1, j, m, n, result, node);
            find(board, visited, i, j + 1, m, n, result, node);
            find(board, visited, i, j - 1, m, n, result, node);

            //reset visited
            visited[i][j] = false;
        }

        private class TrieNode {
            public String val;
            private final int R = 26;
            public TrieNode[] links = new TrieNode[R];
            public boolean isEnd = false;

            public TrieNode() {

            }
        }

        private class Trie {
            public TrieNode root = new TrieNode();

            public void insert(String word) {
                TrieNode currentNode = this.root;
                for (int i = 0; i < word.length(); i++) {
                    char currentChar = word.charAt(i);
                    if (currentNode.links[currentChar - 'a'] == null) {
                        currentNode.links[currentChar - 'a'] = new TrieNode();
                    }
                    currentNode = currentNode.links[currentChar - 'a'];
                }
                currentNode.isEnd = true;
                currentNode.val = word;
            }
        }
    }
}
