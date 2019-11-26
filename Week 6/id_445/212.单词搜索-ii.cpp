/*
 * @lc app=leetcode.cn id=212 lang=cpp
 *
 * [212] 单词搜索 II
 */
#include <vector>
#include <string>
#include <map>
using namespace std;

// @lc code=start

struct Node
{
    bool word;
    string str;
    map<char, Node *> words;
};

class Trie
{
    Node *root;

public:
    Trie()
    {
        root = new Node();
    }
    void insert(string word)
    {
        Node *p = root;
        for (char w : word)
        {
            if (p->words.find(w) == p->words.end())
            {
                Node *n = new Node();
                p->words[w] = n;
            }
            p = p->words[w];
        }
        p->str = word;
        p->word = true;
    }
    void search(vector<string> & res,vector<vector<char>> & board){
        for (int i = 0; i < board.size(); i++)
        {
            for(int j=0;j<board[i].size();j++){
                help(res,board,root,i,j);
            }
        }
        
    }
    void help(vector<string> &res,vector<vector<char>> & board,Node *p,int x,int y){
        if(p->word){
            p->word=false;
            res.push_back(p->str);
            return;
        }
        if(x<0 || x==board.size() || y<0 ||y==board[x].size()) return;
        if(p->words.find(board[x][y])==p->words.end()) return;
        p=p->words[board[x][y]];
        char cur=board[x][y];
        board[x][y]='#';
        help(res,board,p,x+1,y);
        help(res,board,p,x-1,y);
        help(res,board,p,x,y+1);
        help(res,board,p,x,y-1);
        board[x][y]=cur;
    }
};
class Solution
{
public:
    vector<string> findWords(vector<vector<char>> &board, vector<string> &words)
    {
        Trie *t=new Trie();
        vector<string> res;
        for(string & s:words){
            t->insert(s);
        }
        t->search(res,board);
        return res;
    }
};
// @lc code=end
