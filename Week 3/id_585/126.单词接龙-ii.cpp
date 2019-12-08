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
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
       vector<vector<string>> res;
       unordered_set<string> dict(wordList.begin(), wordList.end());
       dict.erase(beginWord);
       if(!dict.count(endWord)) return res;
       queue<vector<string>> q;
       vector<string> temp = {beginWord};
       q.push(temp);
       bool isFind = false;
       while(!q.empty() && !isFind ){
           //遍历q。提取q中的队列的最后一个元素，找到其可能的后继节点，
          //如果后继节点为endWord，结束循环，如果不是，将后继词放入队列的最后一位，并加入队列q中
          //    维护一个subused的set，加入这一层使用过的所有节点，在循环最后并入used。
          int size = q.size();
          unordered_set<string> currUsed;
          for (int i = 0; i < size; i++)
          {
              vector<string> temp = q.front();
              q.pop();
              vector<string> nextNodes = getNeibour(temp.back(), dict);
              for (auto it = nextNodes.begin(); it != nextNodes.end(); it++)
              {
                  if (*it == endWord)
                  {
                      temp.push_back(endWord);
                      isFind = true;
                      res.push_back(temp);
                      break;
                  }
                  else 
                  {
                      temp.push_back(*it);
                      q.push(temp);
                      temp.pop_back();
                      currUsed.insert(*it);
                  }

              }
          }
              //erase the used element in current layer
          for (auto it = currUsed.begin(); it != currUsed.end(); it++)
              dict.erase(*it);
       }
       return res;
    }
private:
    vector<string> getNeibour(string temp, const unordered_set<string> &dict){
        vector<string> nextNodes;
        for(int i = 0; i< temp.size(); i++){
            char c = temp[i];
            for(int j = 0; j < 26; j++){
                temp[i] = 'a' + j;
                if(dict.count(temp) && temp[i] != c)
                nextNodes.push_back(temp);
            }
                temp[i] = c;
        }
        return nextNodes;
    }
};
// @lc code=end

