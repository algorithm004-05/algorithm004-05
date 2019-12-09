/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 */
#include <queue>
#include <string>
using namespace std;

// @lc code=start
class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        int wordCount = wordList.size();
        if (beginWord.length() == 0 || endWord.length() == 0 || wordCount == 0)
            return 0;
        int count = 0, size = 0, step = 1;
        // vector<int> visited(wordCount, 0);
        int visited[wordCount];
        for (int i = 0; i < wordCount; i++)
        {
            visited[i]=0;
        }
        

        queue<string> q;

        q.push(beginWord);
        while (!q.empty())
        {
            size = q.size();
            step++;
            for (int i = 0; i < size; i++)
            {
                string str = q.front();
                q.pop();
                int strLen = str.length();

                for (int j = 0; j < wordCount; j++)
                {
                    count = 0;
                    if (visited[j] == 0)
                    {
                        for (int k = 0; k < strLen; k++)
                        {
                            if (str[k] != wordList[j][k])
                                count++;
                        }
                        if (count == 1)
                        {

                            if (endWord == wordList[j])
                                return step;
                            visited[j] = 1;
                            q.push(wordList[j]);
                        }
                    }
                }
            }
        }
        return 0;
    }
};
// @lc code=end
