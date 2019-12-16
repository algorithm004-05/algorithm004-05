package lsn19_high_dp;

/**
 * 72. 编辑距离
 * 
 * https://leetcode-cn.com/problems/edit-distance/
 */
/**
 * 1. BFS，two-ended BFS 
 * 相关链接-127.单词接龙https://leetcode-cn.com/problems/word-ladder/
 * 
 * 2. DP dp[i][j] //word1.substr(0,i) 与 word2.substr(0,j)之间的编辑距离
 * 
 * ---------------------------------------------------------------------------
 * 1：w1[i]和w2[j]相同 w1: ...x(i) w2: ...x(j) edit_dist(w1,w2) =
 * edit_dist(w1[0:i-1],w2[0:j-1]) 转化下： edit_dist(i,j) = edit_dist(i-1,j-1)//分治
 * 
 * ------------------------------------------------------- 2：w1[i]和w2[j]不同 w1:
 * ...x(i) w2: ...y(j)
 * 
 * edit_dist(i,j) = MIN(edit_dist(i-1,j-1) + 1 edit_dist(i-1,j) + 1
 * edit_dist(i,j-1) + 1)
 * 
 * 如果 word1[i] 与 word2[j] 相同，显然 dp[i][j]=dp[i-1][j-1]
如果 word1[i] 与 word2[j] 不同，那么 dp[i][j] 可以通过
1 、在 dp[i-1][j-1] 的基础上做 replace 操作达到目的
2 、在 dp[i-1][j] 的基础上做 insert 操作达到目的
3 、在 dp[i][j-1] 的基础上做 delete 操作达到目的
取三者最小情况即可
 * 
 */
public class LeetCode_72_555 {

	public static void main(String[] args) {
		LeetCode_72_555 leetcode = new LeetCode_72_555();
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(leetcode.minDistance(word1, word2));

	}

	public int minDistance(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		// 第一行
		for (int j = 1; j <= n2; j++)
			dp[0][j] = dp[0][j - 1] + 1;
		// 第一列
		for (int i = 1; i <= n1; i++)
			dp[i][0] = dp[i - 1][0] + 1;
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
			}
		}
		return dp[n1][n2];
	}

}
