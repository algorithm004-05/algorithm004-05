/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if( matrix.empty() || matrix[0].empty() || matrix[0][0] > target || matrix.back().back() < target) return false;
        int left = 0 , right = matrix.size() - 1;
        while(left < right){
            int  mid = left + (right - left + 1)/2;
            if (matrix[left][0] == target) return true;
            if(target < matrix[mid][0] )
                right = mid - 1;
            else
                left = mid;
        }
        cout<<left<<endl;
        if (target > matrix[left].back()) return false;
        int lo = 0, high = matrix[left].size()-1;
        while(lo <= high) {
            int mid = lo + (high -lo)/2;
            if (matrix[left][mid] == target) return true;
            if(target < matrix[left][mid])
                high  = mid - 1;
            else
                lo = mid + 1; 
        }
        return false;
    }
};
// @lc code=end

