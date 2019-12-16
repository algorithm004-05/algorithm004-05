public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '0'){
                dp[i+1] += dp[i];
                
                if(i != n - 1){
                    Integer j = Integer.parseInt(s.substring(i, i+2));
                    if(j < 27){
                        dp[i+2] += dp[i];
                    }
                }
            } 
            
        }
        
        return dp[n];
    }
}
