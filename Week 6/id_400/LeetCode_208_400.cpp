class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        isEndingchar = false;
        memset(children, 0, sizeof(children));
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *cur = this;
        for (int i = 0; i < word.size(); i++)
        {
            int index = word[i] - 'a';
            if (cur->children[index] == NULL) {
                Trie *new_node = new Trie();
                cur->children[index] = new_node;
            }
            cur = cur->children[index];
        }
        cur->isEndingchar = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *cur = this;
        for (int i = 0; i < word.size(); i++)
        {
            int index = word[i] - 'a';
            if (cur) {
                cur = cur->children[index];
            }
        }
        return (cur && cur->isEndingchar);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *cur = this;
        for (size_t i = 0; i < prefix.size(); i++)
        {
            int index = prefix[i] - 'a';
            if (cur) {
                cur = cur->children[index];
            }
        }
        return (cur != NULL);
    }
private:
    Trie* children[26];
    bool isEndingchar;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
