public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] d = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    d[i][j] = j;
                } else if(j == 0){
                    d[i][j] = i;
                } else {
                    int min = Math.min(d[i-1][j], d[i][j-1]) + 1;
                    d[i][j] = Math.min(min, d[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0:1));
                }
                
                //System.out.println(i + "," + j + "," + d[i][j]);
            }
        }
        
        return d[m][n];
    }
}
