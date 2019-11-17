/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 *
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (28.32%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    3.6K
 * Total Submissions: 12.6K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> paths;
        vector<string> path(1,beginWord);//声明一个大小为1元素为beginWord的vector;
        if(beginWord == endWord){
            paths.push_back(path);
            return paths;
        }
        unordered_set<string> dict(wordList.begin(),wordList.end());
        unordered_set<string> words1,words2;
        words1.insert(beginWord);
        words2.insert(endWord);
        unordered_map<string,vector<string>> nexts;
        bool word1IsBegin = false;
        if (findLaddersHelper(word1,word2,dict,nexts,words1IsBegin))
            getPath(beginWord,endWord,nexts,path,paths);
            return paths;
    }
private:
    bool findLaddersHelper(unordered_set<string> &words1,unordered_set<string> &words2,
     unordered_set<string> &dict, unordered_map<string,vector<string>> &nexts,bool &words1IsBegin){
         words1IsBegin = !words1IsBegin;
         if (word1.empty())
            return false;
         if (word1.size()>word2.size())
            return findLaddersHelper(words2,words1,dict, nexts, words1IsBegin);
        for (auto it = word1.begin();it != word1.end();++it)
            dict.er

     }

};
// @lc code=end

