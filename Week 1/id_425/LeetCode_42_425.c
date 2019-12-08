/*
 * @lc app=leetcode.cn id=42 lang=c
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (46.54%)
 * Likes:    631
 * Dislikes: 0
 * Total Accepted:    32.7K
 * Total Submissions: 69.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// szh 2019-10-20


int trap(int* height, int heightSize){
    int * left = &height[0];               
    int * right = &height[heightSize - 1]; 
    int * cl = left + 1;         
    int * cr = right - 1; 
    int ret = 0;          

    while (cl <= right && cr >= left) {
        if (*left > *right) {
            if (*cr >= *right) {
                ret += *right * (right - cr - 1);
                right = cr;
            }
            else
                ret -= *cr;
            --cr;
        }
        else {
            if (*cl >= *left) {
                ret += *left * (cl - left - 1);
                left = cl;
            }
            else
                ret -= *cl;
            ++cl;
        }
    }
    return ret;
}



// @lc code=end

