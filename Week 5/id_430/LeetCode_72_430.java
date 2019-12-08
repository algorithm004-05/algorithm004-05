/**
 * Created by panda on 2019/11/17.
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_72_430 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m * n == 0) {
                // 注意返回的是m、n中非零的一个
                return m + n;
            }
            // 将前word1前i个字符变成word2前j个字符的最小次数
            int[][] dp = new int[m + 1][n + 1];
            for (int j = 0; j < n + 1; j++) {
                dp[0][j] = j;
            }
            for (int i = 0; i < m + 1; i++) {
                dp[i][0] = i;
            }
            // 行列都从1开始
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    // 当前值受上面的元素和前面的元素同时影响
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        dp[i][j] = 1 + Math.min(
                                // 新增或删除
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                // 修改
                                dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
}
