/*
 * @lc app=leetcode.cn id=70 lang=c
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


int climbStairs(int n){
    if (n<3) return n;
    int f1 = 1,f2=2,f3 =3;
    for (int i =3;i<n+1;++i){
        f3 = f1+f2;
        f1 = f2;
        f2 =f3;
    }
    return f3;
}


// @lc code=end

