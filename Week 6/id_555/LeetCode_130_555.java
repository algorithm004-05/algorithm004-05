package lsn13_tire_disjoint_set;

/**
 * 130. 被围绕的区域
 * 
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 */
public class LeetCode_130_555 {

	public static void main(String[] args) {
		LeetCode_130_555 leetcode = new LeetCode_130_555();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X', }, { 'X', 'X', 'O', 'X', },
				{ 'X', 'O', 'X', 'X', } };

		for (int i = 0; i < board.length; i++) {
			System.out.println(board[i]);
		}
		System.out.println("---------");
		leetcode.solve(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(board[i]);
		}

	}

//	public void solve(char[][] board) {
//		if (board == null || board.length == 0)
//			return;
//		int m = board.length;
//		int n = board[0].length;
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				// 从边缘o开始搜索
//				boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
//				if (isEdge && board[i][j] == 'O') {
//					dfs(board, i, j);
//				}
//			}
//		}
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (board[i][j] == 'O') {
//					board[i][j] = 'X';
//				}
//				if (board[i][j] == '#') {
//					board[i][j] = 'O';
//				}
//			}
//		}
//	}
//
//	public void dfs(char[][] board, int i, int j) {
//		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
//			// board[i][j] == '#' 说明已经搜索过了.
//			return;
//		}
//		board[i][j] = '#';
//		dfs(board, i - 1, j); // 上
//		dfs(board, i + 1, j); // 下
//		dfs(board, i, j - 1); // 左
//		dfs(board, i, j + 1); // 右
//	}

	boolean[][] flag; // flag[i][j]为false，表示board[i][j]赋值为'X'
	int[] vi = { -1, 0, 1, 0 };
	int[] vj = { 0, 1, 0, -1 };

	public void solve(char[][] board) {
		int n = board.length;
		// 小于3行或3列直接返回
		if (n < 3)
			return;
		int m = board[0].length;
		if (m < 3)
			return;
		flag = new boolean[n][m];
		int i = 0, j = 0, a = 0, b = 0, d = 1;
		int total = 2 * (m + n) - 4; // 矩阵的4条边上的元素个数
		for (int k = 1; k <= total; k++) {
			if (board[i][j] == 'O') // 只要发现矩阵的边上的元素为'O',那么与此'O'相接的所以'O'都不被改变
				dfs(i, j, n, m, board);
			a = i + vi[d];
			b = j + vj[d];
			if (a >= n || a < 0 || b >= m || b < 0) {
				d = (d + 1) % 4;
				a = i + vi[d];
				b = j + vj[d];
			}
			i = a;
			j = b;
		}
		for (int p = 0; p < n; p++)
			for (int q = 0; q < m; q++) {
				if (!flag[p][q])
					board[p][q] = 'X';
			}
	}

	void dfs(int i, int j, int n, int m, char[][] board) {
		flag[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int a = i + vi[k], b = j + vj[k];
			// 只有a,b不越界，并且a,b在board数组为'O',而且a,b没走过(即flag[a][b] == false，不然会死循环)
			if (a >= 0 && a < n && b >= 0 && b < m && board[a][b] == 'O' && flag[a][b] == false)
				dfs(a, b, n, m, board);
		}
	}

}
