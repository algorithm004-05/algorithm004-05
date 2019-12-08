package homework.week5;

import java.math.BigDecimal;
import java.math.BigInteger;

//https://leetcode-cn.com/problems/unique-paths/
public class LeetCode_62_590 {
    public int uniquePaths(int m, int n) {
        int[][] arrays = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    arrays[i][j] = 1;
                }
                if (j == 0) {
                    arrays[i][j] = 1;
                }
                if (i != 0 && j != 0) {
                    arrays[i][j] = arrays[i - 1][j] + arrays[i][j - 1];
                }
            }
        }
        return arrays[m - 1][n - 1];
    }
}
