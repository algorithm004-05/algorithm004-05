package week8;
/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 示例 1:
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2:
 *
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leetcode_115_460 {
    public static void main(String[] args) {

    }
    /**
     * 首先搞清楚dp[i][j]、dp[i][j-1]、dp[i-1][j-1]的含义；说白了，i,j就是代表t，s两个字符串的长度，即t[0:i],s[0:j]
     * 1.t[i]==s[j] dp[i][j] = dp[i][j-1]+dp[i-1][j-1]
     * 现在是两个字符相等，dp[i][j-1]的意思就是看一下t[i]与s[j] 不相匹配（不是说不相等），
     * dp[i-1][j-1]就是扩展的时候喽，把t[i]固定的匹配s[j].看之前有几种情况，
     * 两种不会出现交集的，因为s长度不同；
     * 2.t[i]≠ s[j] dp[i][j] = dp[i][j-1]
     * 不相等就相当于 s没添加字符一样，所以就等于s[j-1]的情况
     *
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i =0;i<s.length()+1 ; i++)
            dp[0][i] = 1;
        for(int i=1;i<t.length()+1;i++){
            for(int j=i;j<s.length()+1;j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];//说明S加一个字符不起作用
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
