import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 2019/11/24.
 */
public class LeetCode_212_430 {

    class Solution {

        class TrieNode {
            TrieNode[] edges;
            boolean isWord;
            String val;

            public TrieNode() {
                edges = new TrieNode[26];
                isWord = false;
            }

            public TrieNode get(char c) {
                return edges[c - 'a'];
            }

            public TrieNode addEdge(char c) {
                TrieNode node = get(c);
                if (node == null) {
                    node = new TrieNode();
                    edges[c - 'a'] = node;
                }
                return node;
            }

            public void setIsWord(boolean isWord) {
                this.isWord = isWord;
            }

            public boolean isWord() {
                return isWord;
            }

            public void setVal(String word) {
                this.val = word;
            }

            public String getVal() {
                return val;
            }
        }

        /**
         * Inserts a word into the trie.
         * 其余方法在本题中都用不到，用了效率不高
         */
        public void insert(TrieNode root, String word) {
            int n = word.length();
            TrieNode node = root;
            for (int i = 0; i < n; i++) {
                node = node.addEdge(word.charAt(i));
            }
            node.setIsWord(true);
            node.setVal(word);
        }


        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList();
            TrieNode root = new TrieNode();
            int m = board.length;
            int n = board[0].length;
            for (String s : words) {
                insert(root, s);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    find(board, root, i, j, m, n, res);
                }
            }
            return res;
        }

        // m、n作为参数可节省时间
        void find(char[][] board, TrieNode root, int i, int j, int m, int n, List<String> res) {
            if (root == null || root.get(board[i][j]) == null) {
                return;
            }
            TrieNode node = root.get(board[i][j]);
            if (node.isWord()) {
                res.add(node.val);
                // 防止重复添加词
                node.setIsWord(false);
                // 此时不应该返回，可能还有以此为前缀的词
            }
            char tmp = board[i][j];
            // 标记访问过
            // 事实上用不到回溯，是否访问过可用状态数组表示
            board[i][j] = '@';
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '@') {
                    find(board, node, x, y, m, n, res);
                }
            }
            // 恢复
            board[i][j] = tmp;
        }


    }
}
