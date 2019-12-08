/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (37.12%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 34.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */
// @lc code=start
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(),wordList.end()); //将vector转换为unordered_set
        queue<string> todo;
        todo.push(beginWord);
        int ladder = 1;
        while(!todo.empty()){
            int n = todo.size();
            for (int i=0;i<n; i++){
                string word = todo.front();
                todo.pop();
                if(word == endWord){
                    return ladder;
                }
                dict.erase(word);
                for (int j = 0; j < word.size(); j++){
                    char c = word[j];
                    for (int k = 0; k < 26; k++){
                        word[j]='a'+k;
                        if(dict.find(word)!=dict.end()){
                            todo.push(word);
                        }
                    }
                    word[j] = c;
                }
            }
            ladder++;
        }
        return 0;
    }
};
// @lc code=end

