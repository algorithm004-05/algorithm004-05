/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

class TrieNode{
    TrieNode[] child;//记录孩子节点
    boolean is_end;//记录当前节点是不是一个单词的结束字母
    public TrieNode() {
        child = new TrieNode[26];//子节点数组长度26，0：‘a’，1：‘b’.....
        is_end = false;
    }
}
class Trie {
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ptr = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null) {
                ptr.child[c - 'a'] = new TrieNode();
            }
            ptr = ptr.child[c - 'a'];
        }
        ptr.is_end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return ptr.is_end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i = 0;i < prefix.length();i++) {
            char c = prefix.charAt(i);
            if(ptr.child[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

