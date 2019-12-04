/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        
    }
    unordered_map<char, Trie*> next;
    bool isEnd = false;
    
    /** Inserts a word into the trie. */
    void insert(const string& word) {
        Trie* node = this;
        for (auto c: word){
            if(!node->next.count(c))
                node->next[c] = new Trie();
            node = node->next[c];
        }
        node->isEnd = true;
        return;
    }
    
    /** Returns if the word is in the trie. */
    bool search(const string& word) {
        Trie* node = this;
        for (auto c: word){
            if(!node->next.count(c))
                return false;
            else
                node = node->next[c];
        }
                return node->isEnd ? true : false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(const string& prefix) {
        Trie* node = this;
        for (auto c: prefix){
            if(!node->next.count(c))
                return false;
            node = node->next[c];
        }
                return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end

