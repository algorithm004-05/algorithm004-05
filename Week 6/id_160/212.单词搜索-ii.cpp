/*
 * @lc app=leetcode.cn id=212 lang=cpp
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Trie{
private:
    bool is_string;
    Trie *next[26];
    string str;
    
public:
    Trie(){
        is_string=false;
        str="";
        memset(next,0,sizeof(next));
    }
    void insert(string word)//插入单词，建立前缀树
    {
        Trie *root=this;
        for(auto w:word)
        {
            if(root->next[w-'a']==nullptr)root->next[w-'a']=new Trie();
            root=root->next[w-'a'];
        }
        root->is_string=true;
        root->str=word;
    }
    
    void search(vector<string>& result,vector<vector<char>>& board)
    {
        Trie *root=this;
        for(int i=0;i<board.size();++i)
            for(int j=0;j<board[0].size();++j)
                helper(result,board,root,i,j);
    }
    
    void helper(vector<string>& result,vector<vector<char>>& board,Trie* note,int x,int y)
    {
        if(note->is_string==true){//在board中找到words中一个单词，添加到result中
            note->is_string=false;//将该单词标记为false,防止在word中再次递归到这个单词，从而造成重复添加
            result.push_back(note->str);
            return;
        }
        if(x<0||x==board.size()||y<0||y==board[x].size())return;//超出边界,不能继续递归
        if(board[x][y]=='#'||note->next[board[x][y]-'a']==nullptr)return;//坐标(x,y)对应的字符不在前缀树中，递归方向不对，返回到上一个坐标
        note=note->next[board[x][y]-'a'];//note指向下一个字符节点
        char temp=board[x][y];
        board[x][y]='#';//标记(x,y)对应的字符已被访问过，防止同一个单元格内的字符在一个单词中重复使用
        helper(result,board,note,x+1,y);
        helper(result,board,note,x-1,y);
        helper(result,board,note,x,y+1);
        helper(result,board,note,x,y-1);
        board[x][y]=temp;
    }
};
class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie *root=new Trie();
        vector<string> result;
        for(auto word:words)
            root->insert(word);
        root->search(result,board);
        return result;
    }
};
// @lc code=end

