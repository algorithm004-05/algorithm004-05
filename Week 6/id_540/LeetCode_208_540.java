package com.company;

public class LeetCode_208_540 {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    private class Trie {
        /** Initialize your data structure here. */
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode currentNode = root;
            for (char c : word.toCharArray()) {
                currentNode.addChar(c);
                currentNode = currentNode.getNode(c);
            }

            currentNode.setHasWord(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode endNode = findEndNode(word);
            return endNode != null && endNode.isEndOfWord();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode endNode = findEndNode(prefix);
            return endNode != null;
        }

        private TrieNode findEndNode(String word) {
            TrieNode currentNode = root;
            for (char c : word.toCharArray()) {
                if (!currentNode.hasChar(c)) {
                    return null;
                }
                currentNode = currentNode.getNode(c);
            }

            return currentNode;
        }

        private class TrieNode {
            private TrieNode[] chars = new TrieNode[26];
            private boolean hasWord = false;

            private boolean hasChar(char c) {
                return chars[c - 'a'] != null;
            }

            private TrieNode getNode(char c) {
                return chars[c - 'a'];
            }

            private void addChar(char c) {
                if (!hasChar(c))  {
                    chars[c - 'a'] = new TrieNode();
                }
            }

            private void setHasWord(boolean hasWord) {
                this.hasWord = hasWord;
            }

            private boolean isEndOfWord() {
                return hasWord;
            }
        }
    }
}
