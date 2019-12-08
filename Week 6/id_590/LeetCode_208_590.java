package homework.week6;

//https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
public class LeetCode_208_590 {
    class Trie {
        private TrieNode root;

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
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.containsKey(c)) {
                    temp.put(c, new TrieNode());
                }

                temp = temp.get(c);
                if (i == word.length() - 1) {
                    temp.setEnd();
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.containsKey(c)) {
                    return false;
                }

                temp = temp.get(c);

                if (i == word.length() - 1) {
                    if (!temp.isEnd()) {
                        return false;
                    }
                }

            }
            return true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!temp.containsKey(c)) {
                    return false;
                }

                temp = temp.get(c);
            }
            return true;
        }
    }

    class TrieNode {
        private final int length = 26;

        private TrieNode[] children;

        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[length];
        }

        //1.containsKey(char ch)-->判断当前结点是否某个特定子结点
        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        //2.get(char ch)-->拿到值为ch的子结点
        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        //3.put(char ch,TrieNode node)-->找到当前结点所持有的子结点数组,找到ch对应位置,并放入子结点
        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        //4.setEnd-->如果从根结点到当前结点所代表字符串是一个单词,设置end标识一下
        public void setEnd() {
            isEnd = true;
        }

        //5.isEnd-->判断从根结点到当前结点是不是一个字符串
        public boolean isEnd() {
            return isEnd;
        }


    }
}
