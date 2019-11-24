class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int coloms = matrix.length>0?matrix[0].length:0;
        int[][] dp = new int[rows+1][coloms+1];
        int length = 0;
        for(int i=1;i<dp.length;i++) {
            for (int j=1; j<dp[0].length;j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    length = Math.max(length,dp[i][j]);
                }
            }
        }
        return length*length;
    }
}


