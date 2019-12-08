/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class LeetCode_208_100 {

    /**
     * 字典树
     * insert：时间复杂度为O(N)
     * search: 时间复杂度为O(N)
     * startsWith时间复杂度为O(N)
     * 
     * 字典树比较消耗空间，其空间复杂度为26为底的指数型
     */
    class Trie {
        private TrieNode root;

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

        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (p.children[index] == null) {
                    return false;
                }
            }
            return true;
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