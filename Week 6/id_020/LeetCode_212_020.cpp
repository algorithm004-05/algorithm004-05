// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <string>
#include <set>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
// https://leetcode.com/problems/implement-trie-prefix-tree/

// Question:
// 208. 实现 Trie (前缀树)
// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。


// Solution:
{
/*
class Trie {
public:
    Trie() {}

    void insert(string word) {
        Trie* node = this;
        for (char ch : word) {
            if (!node->next.count(ch))
                node->next[ch] = new Trie();
            node = node->next[ch];
        }
        node->isEnd = true;
    }

    // bool search(string word) {
    //     Trie* node = this;
    //     for (char ch : word) {
    //         if (!node->next.count(ch))
    //             return false;
    //         node = node->next[ch];
    //     }

    //     return node && node->isEnd;
    // }

    // bool startsWith(string prefix) {
    //     Trie* node = this;
    //     for (char ch : prefix) {
    //         if (!node->next.count(ch))
    //             return false;
    //         node = node->next[ch];
    //     }

    //     return true;
    // }

    map<char, Trie*> next = {};
    bool isEnd = false;
};

class Solution {
public:
    set<string> res;
    vector<int> dx = {-1, 0, 1, 0};
    vector<int> dy = {0, -1, 0, 1};
    void helpDfs(Trie* root, vector<vector<char>>& board, int i, int j, string str) {
        // 1.terminator
         if(i < 0|| i >= board.size() || j < 0 || j>= board[0].size() || board[i][j] == '@') return;

        // 2.process
        if (root->next.count(board[i][j])) {
            str += board[i][j];
            root = root->next[board[i][j]];
            if (root->isEnd) res.insert(str);

            // 3.drill down
            char ch = board[i][j];
            board[i][j] = '@';
            for (int dir = 0; dir < 4; dir++) {
                helpDfs(root, board, i + dx[i], j + dy[i], str);
            }

            // 4.revert
            board[i][j] = ch;
        }

    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        // 1.init Trie
        Trie trie;
        for (auto str : words) {
            trie.insert(str);
        }

        // 2. dfs
        int m = board.size();
        int n = board[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helpDfs(&trie, board, i, j, "");
            }
        }

        vector<string> result;
        for(auto it:res)    result.push_back(it);
        return result;
    }
};
*/
}

class TrieNode{
public:
    bool is_end;
    vector<TrieNode*> children;
    TrieNode(){
        is_end=false;
        children=vector<TrieNode*>(26, NULL);
    }   
};

class Trie{
public:
    TrieNode* getRoot(){return root;}
    Trie(vector<string>& words){
        root=new TrieNode();
        for(int i=0; i<words.size(); ++i)
            addWord(words[i]);
    }
    void addWord(const string& word){
        TrieNode* cur=root;
        for(int i=0; i<word.size(); ++i){
            int index=word[i]-'a';
            if(cur->children[index]==NULL)   
               cur->children[index]=new TrieNode();
            cur=cur->children[index];    
        }
        cur->is_end=true;
    }
private:
    TrieNode* root;
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie* trie = new Trie(words);
        TrieNode* root=trie->getRoot();
        set<string> result_set;
        for(int x=0; x<board.size(); ++x)
            for(int y=0; y<board[0].size(); ++y)
                findWords(board, x, y, root, "", result_set);
        
        vector<string> result;
        for(auto it:result_set)    result.push_back(it);
        return result;        
    }
private:
    // 时间复杂度 o(n)
    void findWords(vector<vector<char>>& board, int x, int y, TrieNode* root, string word, set<string>& result){
        if(x<0||x>=board.size()||y<0||y>=board[0].size() || board[x][y]==' ') return;
        
        if(root->children[board[x][y]-'a'] != NULL){
            word=word+board[x][y];
            root=root->children[board[x][y]-'a']; 
            if(root->is_end) result.insert(word);
            char c=board[x][y];
            board[x][y]=' ';
            findWords(board, x+1, y, root, word, result);
            findWords(board, x-1, y, root, word, result);
            findWords(board, x, y+1, root, word, result);
            findWords(board, x, y-1, root, word, result);
            board[x][y]=c;        
        }
    }
};

void leetcode_test_212(void) {
    vector<vector<char>>& board = {{"o","a","a","n"},
                                   {"e","t","a","e"},
                                   {"i","h","k","r"},
                                   {"i","f","l","v"}};
    vector<string> words = {"oath","pea","eat","rain"};
    findWords(board, words); // ["eat","oath"]
}