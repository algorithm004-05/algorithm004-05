/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class TrieNode{
private:
    TrieNode* next[26]{nullptr};
    bool end = false;
public:
    TrieNode(){}

    ~TrieNode(){
        for (int i = 0; i < 26; ++i){
            if(next[i]!=nullptr){
                //printf("delete %c\n", i+'a');
                delete next[i];
            }
        }
    }

    TrieNode* get(char ch){
        // get next TrieNode* corresponding to input char, if not exist, return nullptr
        return next[ch-'a'];
    }

    TrieNode* insert(char ch){
        // insert a char to the TrieNode and return the inserted TrieNode
        if (next[ch-'a'] == nullptr) {
            next[ch-'a'] = new TrieNode();
        }
        return next[ch-'a'];
    }

    void set_end(){
        end = true;
    }

    bool is_end(){
        return end;
    }
};

class Trie{
private:
    TrieNode* root;
public:
    Trie(){
        root = new TrieNode();
    }

    ~Trie(){
        delete root;
    }

    void insert(string s){
        TrieNode* cur = root;
        for(char ch : s){
            cur = cur->insert(ch);
        }
        cur->set_end();
    }

    bool search(string s){
        // search input string in Trie. If end mark is true, return true; else return false.
        TrieNode *cur = root;
        for (char ch : s){
            cur = cur->get(ch);
            if (cur == nullptr) return false;
        }
        return cur->is_end() ? true : false;
    }

    bool startsWith(string prefix) {
        // search input prefix in Trie. neglect end mark.
        TrieNode *cur = root;
        for (char ch : prefix){
            cur = cur->get(ch);
            if (cur == nullptr) return false;
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

