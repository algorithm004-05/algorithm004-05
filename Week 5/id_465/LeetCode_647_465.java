package leetcode.jacf.tech;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author jacf
 * <p>
 * using dynamic programe
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        boolean[][] dp = new boolean[len][len];
        int i;
        int j;
        int row, column;
        boolean current;
        int count = 0;
        for (i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        for (i = 1; i < len; i++) {
            for (j = 0; j <= len - i - 1; j++) {
                row = j;
                column = i + j;
                current = s.charAt(row) == s.charAt(column);
                if (current && (i == 1 || dp[row + 1][column - 1])) {
                    dp[row][column] = true;
                    count++;
                }
            }

        }
        return count;
    }
}
