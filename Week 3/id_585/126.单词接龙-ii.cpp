/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 */

// @lc code=start
//BFS
//单向BFS，利用queue<vector<string>>来存储
//写possibleNext 函数来找出符合的后继节点，
//利用一个set存储前继节点已经使用过的节点
//class Solution {
//public:
//    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
//       vector<vector<string>> res;
//       unordered_set<string> dict(wordList.begin(), wordList.end());
//       dict.erase(beginWord);
//       if(!dict.count(endWord)) return res;
//       queue<vector<string>> q;
//       vector<string> temp = {beginWord};
//       q.push(temp);
//       bool isFind = false;
//       while(!q.empty() && !isFind){
//           //遍历q。提取q中的队列的最后一个元素，找到其可能的后继节点，
//          //如果后继节点为endWord，结束循环，如果不是，将后继词放入队列的最后一位，并加入队列q中
//          //    维护一个subused的set，加入这一层使用过的所有节点，在循环最后并入used。
//          int size = q.size();
//          unordered_set<string> currUsed;
//          for (int i = 0; i < size; i++)
//          {
//              vector<string> temp = q.front();
//              q.pop();
//              vector<string> nextNodes = getNeibour(temp.back(), dict);
//              for (auto it = nextNodes.begin(); it != nextNodes.end(); it++)
//              {
//                  if (*it == endWord)
//                  {
//                      temp.push_back(endWord);
//                      isFind = true;
//                      res.push_back(temp);
//                      break;
//                  }
//                  else if(!isFind) 
//                  {
//                      temp.push_back(*it);
//                      q.push(temp);
//                      temp.pop_back();
//                      currUsed.insert(*it);
//                  }
//
//              }
//          }
//              //erase the used element in current layer
//          for (auto it = currUsed.begin(); it != currUsed.end(); it++)
//              dict.erase(*it);
//       }
//       return res;
//    }
//private:
//    vector<string> getNeibour(string temp, const unordered_set<string> &dict){
//        vector<string> nextNodes;
//        for(int i = 0; i< temp.size(); i++){
//            char c = temp[i];
//            for(int j = 0; j < 26; j++){
//                temp[i] = 'a' + j;
//                if(dict.count(temp) && temp[i] != c)
//                nextNodes.push_back(temp);
//            }
//                temp[i] = c;
//        }
//        return nextNodes;
//    }
//};
//two end bfs
//use map<string,vector<string>> to record the next node , use recursion to build the result

//use isfront to control how the word added to the children map
class Solution
{
public:
    int count=0;
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        vector<vector<string>> res;
        vector<string> path(1,beginWord);
        unordered_map<string, vector<string>> children;
        if (dict.find(endWord) == dict.end())
            return res;
        if (findChildren(beginWord, endWord, children, dict))
        {
            buildLadder(beginWord, endWord, res, path, children);
        }
        return res;
    }

private:
    bool findChildren(
        string beginWord,
        string endWord,
        unordered_map<string, vector<string>> &children,
        unordered_set<string> &dict)
    {
        bool isFind = false;
        bool isHead =true;
        unordered_set<string> head{beginWord}, tail{endWord};
        int len = beginWord.size();
        
        while (!head.empty() && !tail.empty())
        {
                 count++;
            unordered_set<string> temp;
            if (head.size() > tail.size())
            {
                isHead = !isHead;
                swap(head, tail);
            }
            for (auto word : head)
            {
                dict.erase(word);
                for ( int i = 0; i < len; i++) // i一定要赋值
                {
                    string headWord = word;
                    char c = word[i];
                    for (int j = 0; j < 26; j++)
                    {
                        word[i] = 'a' + j;
                        if (tail.find(word) != tail.end())
                        {
                            isFind = true;
                            isHead ? children[headWord].push_back(word) : children[word].push_back(headWord);
                        }
                        else if (!isFind && dict.find(word) != dict.end())
                        {
                            isHead ? children[headWord].push_back(word) : children[word].push_back(headWord);
                            temp.insert(word);
                        }
                    }
                    word[i] = c;
                }
            }
            if (isFind){
                return true;
            }

            for (auto word : temp) // if the head inversed, this used word should also excluded from the tail 
                dict.erase(word);
            swap(head, temp);
        }
            return false;
    }
    void buildLadder(string beginWord,
                     string endWord,
                     vector<vector<string>> &res,
                     vector<string> &path,
                     unordered_map<string, vector<string>> &children)
    {
        if (beginWord == endWord)
        {
            res.push_back(path);
            return;
        }
        for (auto it : children[beginWord])
        { //take note
            path.push_back(it);
            buildLadder(it, endWord, res, path, children);
            path.pop_back();
        }
    }
};
// @lc code=end

