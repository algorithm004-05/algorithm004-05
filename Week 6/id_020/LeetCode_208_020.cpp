// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
// https://leetcode.com/problems/implement-trie-prefix-tree/

// Question:
// 208. 实现 Trie (前缀树)
// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。


// Solution:
class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {}
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* node = this;
        for (char ch : word) {
            ch -= 'a';
            if (!node->next[ch])
                node->next[ch] = new Trie();
            node = node->next[ch];
        }
        node->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* node = this;
        for (char ch : word) {
            ch -= 'a';
            if (!node->next[ch]) return false;
            node = node->next[ch];
        }

        return node && node->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie* node = this;
        for (char ch : prefix) {
            ch -= 'a';
            if (!node->next[ch]) return false;
            node = node->next[ch];
        }

        return true;
    }

private:
    Trie* next[26] = {};
    bool isEnd = false;
};

{
// class Trie {
// public:
//     Trie() {}

//     void insert(string word) {
//         Trie* node = this;
//         for (char ch : word) {
//             if (!node->next.count(ch))
//                 node->next[ch] = new Trie();
//             node = node->next[ch];
//         }
//         node->isEnd = true;
//     }

//     bool search(string word) {
//         Trie* node = this;
//         for (char ch : word) {
//             if (!node->next.count(ch))
//                 return false;
//             node = node->next[ch];
//         }

//         return node && node->isEnd;
//     }

//     bool startsWith(string prefix) {
//         Trie* node = this;
//         for (char ch : word) {
//             if (!node->next.count(ch))
//                 return false;
//             node = node->next[ch];
//         }

//         return true;
//     }

// private:
//     map<char, Trie*> next = {};
//     bool isEnd = false;
// };
}

void leetcode_test_208(void) {
    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // 返回 true
    trie.search("app");     // 返回 false
    trie.startsWith("app"); // 返回 true
    trie.insert("app");   
    trie.search("app");     // 返回 true
}