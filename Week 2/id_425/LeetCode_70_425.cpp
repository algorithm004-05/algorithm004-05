/*
 * @lc app=leetcode.cn id=70 lang=cpp
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (46.85%)
 * Likes:    667
 * Dislikes: 0
 * Total Accepted:    90.1K
 * Total Submissions: 192.1K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int climbStairs(int n) {
        if(!isStairOk(n)) return 0;
        const vector<int> *s=StairNum(n);
        return (*s)[n-1];
    }
    const vector<int>* StairNum (int n){
        static vector<int> s;
        for (int i=s.size(); i<n ;++i){
            if(i==0) s.push_back(1);
            else if (i==1 ) s.push_back(2);
            else s.push_back(s[i-1]+s[i-2]);
        }
        return &s;
    }
        
    bool isStairOk(int n){
        if(n<=0){
        return false;
        }
        return true;
    }
};
// @lc code=end

