package week8;
/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class Leetcode_44_460 {
    /**
     * （一）状态
     *
     * f[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配
     * （二）转移方程
     *
     * 如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “.”
     * f[i][j] = f[i - 1][j - 1]
     * 如果s2的第 j 个字符为 *
     * 若s2的第 j 个字符匹配空串, f[i][j] = f[i][j - 1]
     * 若s2的第 j 个字符匹配s1的第 i 个字符, f[i][j] = f[i - 1][j]
     * 这里注意不是 f[i - 1][j - 1]， 举个例子就明白了 (abc, a*) f[3][2] = f[2][2]
     * （三）初始化
     *
     * f[0][i] = f[0][i - 1] && s2[i] == *
     * 即s1的前0个字符和s2的前i个字符能否匹配
     * （四）结果
     *
     * f[m][n]
     *
     * 作者：a380922457
     * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}
