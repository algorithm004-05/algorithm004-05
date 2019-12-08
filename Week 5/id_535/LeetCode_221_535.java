/**
 * created by lchen on 2019/11/17
 */
public class LeetCode_221_535 {

    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[]pre = new int[n+1];
        int[]cur = new int[n+1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    cur[j] = 1 + Math.min(pre[j-1], Math.min(pre[j], cur[j-1]));
                    max = Math.max(max, cur[j]);
                }
                pre[j - 1] = cur[j - 1];
                cur[j - 1] = 0;
            }
            pre[n] = cur[n];
            cur[n] = 0;
        }
        return max*max;
    }
}
