/*
 * @lc app=leetcode.cn id=212 lang=cpp
 *
 * [212] 单词搜索 II
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
    int search(const string& word) {
        Trie* node = this;
        for (auto c: word){
            if(!node->next.count(c))
                return 0;
            else
                node = node->next[c];
        }
                return node->isEnd ? 1 : 2;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
};
class Solution {
public:
    vector<int>
        dx = {-1, 1, 0, 0},
        dy = {0, 0, -1, 1};
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        set<string> res = {};
        vector<string> resFinal = {};
        Trie tri;
        for (int i = 0; i < words.size(); i++) tri.insert(words[i]);
        for(int i = 0 ; i < board.size(); i++){

            for (int j = 0; j < board[0].size(); j++)
            {
                    string fir = {board[i][j]};
                    board[i][j] = '@';
                    if(tri.search(fir) != 0)
                        recursion(fir, res, board, tri, i, j);
                    board[i][j] = fir[0];
            }
        }
        
        resFinal.assign(res.begin(), res.end());
        return resFinal;
    }
    void recursion(string& curr, set<string>& res, vector<vector<char>>& board,  Trie& tri, int x, int y){
        int how = tri.search(curr);
        if (how == 0)
        {
            return;
        }
        if(how == 1 ){
            res.insert(curr);
        }
        for (int i = 0; i < 4; i++)
        {
            int x1 = x + dx[i], y1 = y + dy[i];
            if (x1 >= 0 && x1 < board.size() && y1 >= 0 && y1 < board[0].size())
            {
                char a = board[x1][y1];
                if (a != '@')
                {
                    char temp = board[x1][y1];
                    curr += temp;
                    board[x1][y1] = '@';
                    recursion(curr, res, board, tri, x1, y1);
                    board[x1][y1] = temp;
                    curr.pop_back();
                }
            }
        }
    }
};
// @lc code=end

