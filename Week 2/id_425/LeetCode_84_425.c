/*
 * @lc app=leetcode.cn id=84 lang=c
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (37.20%)
 * Likes:    301
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 44.3K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */

// @lc code=start
// szh 2019-10-23
// 1.0

int largestRectangleArea(int* heights, int heightsSize){
    int l =0;
    int r = heightsSize-1;
    return largestArea(heights,l,r);
}
int largestArea(int *s,int l, int r){
    if (l >r) return 0;
    if (l == r) {
        return s[l];
    }
    else{
        int min = mini(s,l,r);
        int area = (r-l+1)* s[min];
        int lare = largestArea(s,l,min-1);
        int rare = largestArea(s,min+1,r);
        area =  (area > lare ? (area>rare ? area:rare):(lare>rare ? lare:rare));
        return area;
    }
}
int mini(int *s,int l, int r){
    int min=s[l];
    int temp = l;
    for(int i=l+1;i<r+1;++i){
       if( min>s[i]){
         min=s[i];
           temp = i;
       }
    }
    return temp;
}


// @lc code=end

