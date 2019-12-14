/*
 * @lc app=leetcode.cn id=433 lang=cpp
 *
 * [433] 最小基因变化
 */
#include <vector>
#include <string>
#include <queue>
using namespace std;
// @lc code=start
class Solution
{
public:
    // ///bfs use array
    // int minMutation(string start, string end, vector<string> &bank)
    // {
        
    //     if(start.length()==0||end.length()==0|| bank.size()==0)return -1;
    //     int strLen = 0, count = 0, size = 0, bsize = bank.size(), step = 0;
    //     int visited[bsize];
    //     for (int i = 0; i < bsize; i++)
    //     {
    //         visited[i] = 0;
    //     }

    //     queue<string> q;
    //     q.push(start);
    //     while (!q.empty())
    //     {
    //         size = q.size();
    //         step++;
    //         for (int i = 0; i < size; i++)
    //         {
    //             string &s = q.front();
    //             q.pop();
    //             strLen = s.length();
    //             for (int k = 0; k < bsize; k++)
    //             {
    //                 count = 0;
    //                 if (visited[k] == 0)
    //                 {
    //                     for (int j = 0; j < strLen; j++)
    //                     {
    //                         if (s[j] != bank[k][j])
    //                             count++;
    //                     }
    //                     if (count == 1)
    //                     {

    //                         if (bank[k] == end)
    //                             return step;
    //                         q.push(bank[k]);
    //                         visited[k]=1;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return -1;
    // }
    ///bfs use vector
    ///bfs use array
    int minMutation(string start, string end, vector<string> &bank)
    {
        
        if(start.length()==0||end.length()==0|| bank.size()==0)return -1;
        int strLen = 0, count = 0, size = 0, bsize = bank.size(), step = 0;
        vector<int> visited(bsize,0);


        queue<string> q;
        q.push(start);
        while (!q.empty())
        {
            size = q.size();
            step++;
            for (int i = 0; i < size; i++)
            {
                string &s = q.front();
                q.pop();
                strLen = s.length();
                for (int k = 0; k < bsize; k++)
                {
                    count = 0;
                    if (visited[k] == 0)
                    {
                        for (int j = 0; j < strLen; j++)
                        {
                            if (s[j] != bank[k][j])
                                count++;
                        }
                        if (count == 1)
                        {

                            if (bank[k] == end)
                                return step;
                            q.push(bank[k]);
                            visited[k]=1;
                        }
                    }
                }
            }
        }
        return -1;
    }

};
// @lc code=end
