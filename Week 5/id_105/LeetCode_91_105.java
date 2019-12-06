package id_105;


import java.util.Arrays;

public class LeetCode_91_105 {



    public int numDecodings(String s) {


        if (s == null || s.length() == 0 || s.equals("0")) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        System.out.println("==============================");
        for (int i = 2; i <= n ; i++){
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9){
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
//            System.out.printf("%d  , dp[%d]: %d \r\n", i, i, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        // 设定动态规划的初始值
        int[] res = new int[s.length() + 1];
        res[s.length()] = 1;

        // 从初始值前一位开始，向前进行动态规划
        for (int idx = s.length() - 1; idx >= 0; idx--) {
            char curCh = s.charAt(idx);
            if(curCh != '0'){
                res[idx] += res[idx + 1];
                if(idx < s.length() - 1){
                    char nextCh = s.charAt(idx + 1);
                    if((curCh - '0')* 10 + nextCh - '0' <= 26){
                        res[idx] += res[idx + 2];
                    }
                }
            }
        }
        return res[0];
    }


    public static void main(String[] args) {
        LeetCode_91_105 l = new LeetCode_91_105();

        System.out.println(l.numDecodings("12"));
        System.out.println(l.numDecodings("226"));
        System.out.println(l.numDecodings("0"));
        System.out.println(l.numDecodings("120"));
        System.out.println(l.numDecodings("10"));
        System.out.println(l.numDecodings("12012"));

    }
}
