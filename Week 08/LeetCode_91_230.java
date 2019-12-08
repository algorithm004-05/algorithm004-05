
 /*
    * 多行注释为自己的代码，写的很明显不是很好
    * 也存在问题
    * */
public static int numDecodings(String s) {
        //first method
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 2) - '0' <= 6)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
//        int len = s.length();
//        int[] dp = new int[len];
//        if (s.charAt(0) == '0') return 0;
//        else  dp[0] = 1;
//        for (int i = 1; i < len; i++) {
//            if (s.charAt(i) == '0') {
//                System.out.println("s.charAt(i) == '0'");
//                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
//                    if (dp[i - 1] - 1 == 0) dp[1] = 1;
//                    else {
//                        if (i >= 3) dp[i] = dp[i - 1] - 2;
//                        else dp[i] = dp[i - 1] - 1;
//                    }
//                }
//                else {
//                    return 0;
//                }
//            } else {
////                System.out.println("else");
//                int num = Integer.parseInt(s.substring(i - 1, i + 1));
//                if (num <= 26 && num > 10) {
//                    if (i >= 3) dp[i] = dp[i - 1] + 2;
//                    else dp[i] = dp[i - 1] + 1;
//                }
//                else dp[i] = dp[i - 1];
//            }
//            System.out.println(Arrays.toString(dp));
//        }
//        return dp[len - 1];
    }
