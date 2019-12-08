/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 */

// @lc code=start
//BFS
//class Solution
//{
//public:
//    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
//    {
//        queue<string> currL;
//        currL.push(beginWord);
//        unordered_set<string> dict(wordList.begin(), wordList.end());
//        int level = 1;
//        while (!currL.empty())
//        {
//            // scan the currL;
//            // check the possible word and push in the queue, level++
//            int n = currL.size();
//            for (int i = 0; i < n; i++)
//            {
//                string word = currL.front();
//                currL.pop();
//                for (int j = 0; j < word.size(); j++)
//                {
//                    char temp = word[j];
//                    for (int k = 0; k < 26; k++)
//                    {
//                        word[j] = 'a' + k;
//                        if (dict.find(word) != dict.end())
//                        {
//                            if (word == endWord)
//                                return level + 1;
//                            currL.push(word);
//                            dict.erase(word);
//                        }
//                        word[j] = temp;
//                    }
//                }
//            }
//            level++;
//        }
//        //不要忽略
//        return 0;
//    }
//};
//BFS two end search solution
class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> dict(wordList.begin(), wordList.end()), front, back, *pfront, *pback;
        front.insert(beginWord), back.insert(endWord);
        if (dict.find(endWord) == dict.end()) return 0;
        int level = 1;
            //choice the scan direction according to the size of search set
            // scan the set and get the next level; if the current set has the same element as the opposite one 
            //return level
        while (!front.empty() && !back.empty())
        {
            if (front.size() < back.size())
            {
                pfront = &front;
                pback = &back;
            }
            else
            {
                pfront = &back;
                pback = &front;
            }
            unordered_set<string> temp;
            for (auto it = pfront->begin(); it != pfront->end(); it++)
            {
                string word = *it;
                for (int j = 0; j < word.size(); j++)
                {
                    char c = word[j];
                    for (int k = 0; k < 26; k++)
                    {
                        word[j] = 'a' + k;
                        if (pback->find(word) != pback->end())
                            return level + 1;
                        if (dict.find(word) != dict.end())
                        {
                            temp.insert(word);
                            dict.erase(word);
                        }
                        word[j] = c;
                    }
                }
            }
            level++;
            pfront->swap(temp);
        }
        //不要忽略
        return 0 ;
    }
};
// @lc code=end

