/*
 * @lc app=leetcode.cn id=63 lang=cpp
 *
 * [63] 不同路径 II
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution
{
public:
    //solution 1
    // int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
    // {
    //     if (obstacleGrid.size() == 0 || obstacleGrid[0].size() == 0)
    //         return 0;
    //     // if (obstacleGrid.size() == 1 || obstacleGrid[0].size() == 1)
    //     //     return 1;

    //     vector<vector<long>> steps(obstacleGrid.size(), vector<long>(obstacleGrid[0].size(), 1));

    //         int rowNum=obstacleGrid.size()-1, temp1=1;
    //         for (int j = obstacleGrid[0].size() - 1; j >= 0; j--)
    //         {
    //             if (obstacleGrid[rowNum][j] == 1) temp1=0;
    //             steps[rowNum][j] = temp1;
    //         }

    //         rowNum= obstacleGrid[0].size() - 1, temp1=1;
    //         for (int j = obstacleGrid.size() - 1; j >= 0; j--)
    //         {
    //             if (obstacleGrid[j][rowNum] == 1) temp1=0;
    //                 steps[j][rowNum] = temp1;;
    //         }

    //     for (int i = steps.size() - 2; i >= 0; i--)
    //     {
    //         for (int j = steps[0].size() - 2; j >= 0; j--)
    //         {
    //             steps[i][j] =obstacleGrid[i][j] ==1?0:steps[i][j+1]+steps[i+1][j];
    //         }
    //     }

    //     return steps[0][0];
    // }

    //solution 2
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
    {
        if (obstacleGrid.size() == 0 || obstacleGrid[0].size() == 0)
            return 0;

        vector<vector<long>> steps(obstacleGrid.size(), vector<long>(obstacleGrid[0].size(), 1));

        int rowNum = obstacleGrid.size() - 1, colNum = obstacleGrid[0].size() - 1;
        steps[rowNum][colNum] = obstacleGrid[rowNum][colNum] == 1 ? 0 : 1;
        for (int j = colNum - 1; j >= 0; j--)
            steps[rowNum][j] = obstacleGrid[rowNum][j] == 1 ? 0 : steps[rowNum][j + 1];

        // rowNum= obstacleGrid[0].size() - 1
        for (int j = rowNum - 1; j >= 0; j--)
            steps[j][colNum] = steps[j][colNum] = obstacleGrid[j][colNum] == 1 ? 0 : steps[j +1][colNum];

        for (int i = steps.size() - 2; i >= 0; i--)
        {
            for (int j = steps[0].size() - 2; j >= 0; j--)
            {
                steps[i][j] = obstacleGrid[i][j] == 1 ? 0 : steps[i][j + 1] + steps[i + 1][j];
            }
        }

        return steps[0][0];
    }
};
// @lc code=end
