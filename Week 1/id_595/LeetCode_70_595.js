/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (46.86%)
 * Likes:    667
 * Dislikes: 0
 * Total Accepted:    91.1K
 * Total Submissions: 194K
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
/**
 * @param {number} n
 * @return {number}
 */

//  思路：实际上是一个Fibonacci数列。
//  以n=3距离，我们反着想,因为只能上1阶或者2阶台阶，所以就是从第1级台阶跳2级，或者从第2级台阶跳1级，
// 所以我们只需要知道把「第1级台阶的数目」+「第2级台阶的数目」，就得到第3级台阶的数目，即f(3) = f(2) + f(1)
// 经过泛化，我们得到公式：f(n) = f(n-1) + f(n-2)

// 解法1：使用递归(不过在Leetcode上超出时间限制了)
var climbStairs = function(n) {
    if(n <= 2) return n;
    return climbStairs(n - 1) + climbStairs(n - 2);    
};

// 解法2：将递归的方法使用for循环解决
var climbStairs = function(n) {
    if(n <= 2) return n;
    let arr = [1, 1, 2]; // arr数组的下表就是n

    for(let i = 3; i <= n; i++) {
        arr[i] = arr[i- 1] + arr[i - 2];
    }

    return arr[n];
};
// @lc code=end

