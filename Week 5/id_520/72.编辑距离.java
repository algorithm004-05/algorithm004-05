/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int min(int a,int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
    public int minDistance(String word1, String word2) {
        // 利用课上提供的思路，涉及两个字符串比较的时候，把他们俩一个放行，一个放列上
        //动态规划  dp[i][j]代表 word1 的 i 位转换成 word2 的 j 位置需要最少步数
        
        // dp矩阵中元素的含义：
        //dp[i-1][j-1] ： 替换 或 相同跳过, 但是跳过不会增加操作数
        //dp[i-1][j] ： 删除 word1 当前字符
        //dp[i][j-1] ： 在 word1 当前位置插入和 word2 那个位置相同的元素

        //递归，自底向上
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i = 1 ; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1 ; j <= n; j++)
            dp[0][j] = j;
        //自底向上求解，从完全遍历完字符串开始
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ;j++) {
                //如果当前位置字符相同，则跳过
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min(
                        dp[i-1][j-1]+1,
                        dp[i][j-1]+1,
                        dp[i-1][j]+1
                    );
            }
        }
        //dp[m][n]存储 word1 和 word2 之间的最小距离
        return dp[m][n];
    }


}
// @lc code=end

