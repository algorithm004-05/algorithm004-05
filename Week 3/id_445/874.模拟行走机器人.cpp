/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 */
#include <vector>
#include <set>


using namespace std;
// @lc code=start
class Solution
{
public:
    // int robotSim(vector<int> &commands, vector<vector<int>> &obstacles)
    // {
    //     int location[] = {0, 0};
    //     int tempLocation[] = {0, 0};
    //     int maxDistance = 0;
    //     set<pair<int, int>> obstaclesSet;
    //     for (auto obs : obstacles)
    //         obstaclesSet.insert(make_pair(obs[0], obs[1]));

    //     int direction = 1, navigation = 1;
    //     for (int i = 0; i < commands.size(); i++)
    //     {
    //         if (commands[i] > 0)
    //         {

    //             for (int j = 0; j < commands[i]; j++)
    //             {
    //                 tempLocation[direction] = location[direction] + navigation;
    //                 if (obstaclesSet.find(make_pair(tempLocation[0], tempLocation[1])) != obstaclesSet.end())
    //                     break;

                    
    //                 // if (obstaclesSet.find(make_pair(tempLocation[0], tempLocation[1])) == obstaclesSet.end())
    //                 // {
    //                 location[direction] = tempLocation[direction];
    //                 maxDistance = max(maxDistance, (location[0] * location[0] + location[1] * location[1]));

    //                 // }
    //             }
                
    //         }
    //         ////turn direction
    //         else if (commands[i] == -1)
    //         {
    //             if (direction == 1)
    //             {
    //                 direction = 0;
    //             }
    //             else
    //             {
    //                 direction = 1;
    //                 navigation = -1 * navigation;
    //             }
    //         }
    //         else if (commands[i] == -2)
    //         {
    //             if (direction == 0)
    //             {
    //                 direction = 1;
    //             }
    //             else
    //             {
    //                 direction = 0;
    //                 navigation = -1 * navigation;
    //             }
    //         }
    //     }

    //     return maxDistance;
    // }

    int robotSim(vector<int> &commands, vector<vector<int>> &obstacles)
    {
        // int location[] = {0, 0};
        // int tempLocation[] = {0, 0};
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int x=0,y=0;
        int di=0;

        int maxDistance = 0;
        set<pair<int, int>> obstaclesSet;
        for (auto obs : obstacles)
            obstaclesSet.insert(make_pair(obs[0], obs[1]));

        int direction = 1, navigation = 1;
        for (int i = 0; i < commands.size(); i++)
        {
            if (commands[i] > 0)
            {

                for (int j = 0; j < commands[i]; j++)
                {
                    int nx=x+dx[di];
                    int ny=y+dy[di];

                    if (obstaclesSet.find(make_pair(nx,ny)) == obstaclesSet.end())
                    {
                    x=nx;
                    y=ny;
                    maxDistance = max(maxDistance, (x * x + y * y));

                    }
                }
                
            }
            ////turn direction
            else if (commands[i] == -2)
                di = (di + 3) % 4;
            else if (commands[i] == -1)
                di = (di + 1) % 4;
        }

        return maxDistance;
    }
};
// @lc code=end
