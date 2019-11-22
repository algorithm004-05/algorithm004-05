/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.17 19:05
 * @Description:
 */
public class A647 {
    public static void main(String[] args) {
        A647 a647 = new A647();
        String s = "aaa";
        System.out.println(a647.countSubstrings(s));

    }

    /**
     * 核心思想，获取一个点，同时往左右两边走，如果相等则是回文数
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j)
                    dp[i][j] = true;
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j <= i + 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) result++;
            }
        }

        return result;
    }
}
