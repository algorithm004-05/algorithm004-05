package geektime.dp;

import java.util.List;

public class MinNumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //define sts array
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        //initial sts array
        int initialLevel = triangle.size() - 1;
        for (int i = 0; i < triangle.get(initialLevel).size(); i++) {
            dp[i] = triangle.get(initialLevel).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //递推公式
                dp[j] = Math.min(dp[j] + triangle.get(i).get(j),dp[j+1] + triangle.get(i).get(j));
            }
        }
        return dp[0];
    }
}
