package xyz.isok.algorithm.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/maximal-square/submissions/
 */
public class No221MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        No221MaximalSquare maximalSquare = new No221MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));

    }

    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) return 0;
        int w = matrix[0].length;
        int[][] dp = new int[h + 1][w + 1];
        int square = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    square = Math.max(square, dp[i][j]);
                }
            }
        }
        return square * square;
    }
}
