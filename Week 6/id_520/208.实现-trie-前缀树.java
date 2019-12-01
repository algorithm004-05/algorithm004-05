/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
//LeetCode国际站高票答案
class TrieNode {
    //给当前节点的标记，记录是否为单词
    public boolean isWord;
    // 类似C语言的指针，字典树的每一个节点都要放26个字母，而且每一个字母都要能够指向其他TrieNode
    // 每一个数组用new初始化的时候都必须指定大小，否则系统不知道分配多少内存
    // "children" links to node children
    public TrieNode[] children = new TrieNode[26];
    // 无参构造函数，如果类中定义了带参构造函数，系统不会默认生成
    // public TrieNode() {}
}


class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 如果当前遍历的char在之前的字典树中没有，就根据它创建一个
            //这里使用ASCII码来标记
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
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

