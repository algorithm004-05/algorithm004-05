/**
 * Created by panda on 2019/11/24.
 */
public class LeetCode_208_430 {
    class Trie {

        TrieNode root;

        class TrieNode {
            TrieNode[] edges;
            boolean isWord;

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
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            int n = word.length();
            TrieNode node = root;
            for (int i = 0; i < n; i++) {
                node = node.addEdge(word.charAt(i));
            }
            node.setIsWord(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = findNode(word);
            return node != null && node.isWord();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }


        private TrieNode findNode(String prefix) {
            int n = prefix.length();
            TrieNode node = root;
            for (int i = 0; i < n; i++) {
                node = node.get(prefix.charAt(i));
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }
}
