package lsn13_tire_disjoint_set;

/**
 * 547. 朋友圈
 * 
 * https://leetcode-cn.com/problems/friend-circles/
 *
 */
public class LeetCode_547_555 {

	public static void main(String[] args) {
		LeetCode_547_555 leetcode = new LeetCode_547_555();

		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int res = leetcode.findCircleNum(M);
		System.out.println(res);
	}

	public void dfs(int[][] M, int[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				dfs(M, visited, j);
			}
		}
	}

	public int findCircleNum(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				dfs(M, visited, i);
				count++;
			}
		}
		return count;
	}

}
