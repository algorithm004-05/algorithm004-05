/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int rows=matrix.size();
        if(rows<1) return false;
        int cols=matrix[0].size();
        if(cols<1) return false;
        int low=0,high=rows-1,mid=0,innerMid=0;
        while (low<=high)
        {
            mid=(low+high)/2;
            if(target>=matrix[mid][0]&&matrix[mid][cols-1] >= target){
                low=0;
                high=matrix[mid].size()-1;
                while (low<=high)
                {
                    innerMid=(low+high)/2;
                    if(target==matrix[mid][innerMid]) return true;
                    if(target>matrix[mid][innerMid]) low=innerMid+1;
                    else high=innerMid-1;
                }
                return false;
                
            }
            if(matrix[mid][0]>target) high=mid-1;
            else low=mid+1;

        }
        return false;
        
    }
};
// @lc code=end

