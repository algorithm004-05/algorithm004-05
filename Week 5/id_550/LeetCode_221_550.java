public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        
        if (m == 0) {
            return 0;
        }
        
        int n = matrix[0].length;
        
        int[][] ones = new int[m+1][n+1];
        int result = 0; 
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    ones[i][j] = Math.min(Math.min(ones[i-1][j-1], ones[i][j-1]), ones[i-1][j]) + 1;
                    result = Math.max(result, ones[i][j]);
                }
            }
        }
        
        return result * result;
    }
}
