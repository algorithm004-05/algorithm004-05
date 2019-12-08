/**
 * created by lchen on 2019/11/17
 */
public class LeetCode_91_535 {

    public static void main(String[] args) {
        LeetCode_91_535 l = new LeetCode_91_535();
        System.out.println(l.numDecodings("110"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    //递归
    public int dp(int i, String s) {
        if (s.startsWith("0")) return 0;
        int start = Integer.valueOf(String.valueOf(s.charAt(i)));
        if (i == 0 && start != 0) return 1;
        if (i == 0) return 0;
        int end = Integer.valueOf(String.valueOf(s.charAt(i - 1)));
        if (start == 0 && (end > 2 || end == 0)) return 0;
        if (i == 1 && start <= 6 && end <= 2 && start > 0) {
            return 2;
        }
        if (start == 0) return dp(i - 1, s) - 1;
        if (start <= 6 && end <= 2 && start > 0 && end > 0) {
            return dp(i - 1, s) + 1;
        } else {
            return dp(i - 1, s);
        }
    }

}