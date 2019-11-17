/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 */
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution
{
private:
    vector<vector<string>> res;
    string endWord;
     int wordCount;
     vector<string> initRes;


public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> dict(wordList.begin(),wordList.end());
        if(dict.count(endWord)==0)return{};
        unordered_map<string,unordered_set<string>> trace;
        unordered_set<string> q={beginWord},dels;
        for(;q.size()&&trace.count(endWord)==0;q=dels){
            for(const string &word:q)dict.erase(word);
            dels.clear();
            for(const string &word:q){
                for (int i = 0; i < word.length(); i++)
                {
                    string s=word;
                    for (char ch='a'; ch <= 'z'; ++ch)
                    {
                        if(word[i]==ch)continue;
                        s[i]=ch;
                        
                        if(dict.find(s)==dict.end())continue;
                        trace[s].insert(word);
                        dels.insert(s);
                    }
                    
                }
                
            }
        }
        if(trace.size()==0) return {};
        vector<vector<string>> result;
        dfs(trace,endWord,{},result);
        return result;
    }
    void dfs(unordered_map<string,unordered_set<string>> &trace, const string &last, vector<string> path,vector<vector<string>> &vs)
    {
      path.push_back(last);
      if(trace.count(last)==0){
          reverse(path.begin(),path.end());
          vs.push_back(path);
          return;
      }
      for(const string &word:trace[last])dfs(trace,word,path,vs);
    }
};
// @lc code=end
