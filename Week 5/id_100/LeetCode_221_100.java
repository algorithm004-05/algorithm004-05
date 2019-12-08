/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class LeetCode_221_100 {


    /**
     * 需要求正方形面积，只需要求得出现1的最大边长即可
     * 得出dp方程为：
     *  当matrix[i][j] == 0时：
     *      sub_min(i, j) = min(sub_min(i - 1, j), sub_min(i, j - 1), sub_min(i - 1, j - 1)) + 1;
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        int[][] dp = new int[m + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}