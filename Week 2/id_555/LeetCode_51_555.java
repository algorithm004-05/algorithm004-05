package lsn08.divide;

import java.util.List;

/**
 * 
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * 51. N皇后
 * 
 */
public class LeetCode_51_555 {

	public static void main(String[] args) {
		LeetCode_51_555 leetcode = new LeetCode_51_555();
		leetcode.calnqueens(0);
	}

	int n = 8;

	int[] result = new int[n];

	public void calnqueens(int row) {
		if (row == n) {
			printQueues(result);
			return;
		}
		for (int column = 0; column < n; ++column) {
			if (isOk(row, column)) {
				result[row] = column;
				calnqueens(row + 1);
			}
		}

	}

	private boolean isOk(int row, int column) {
		int leftup = column - 1, rightup = column + 1;
		for (int i = row - 1; i >= 0; --i) {
			if (result[i] == column)
				return false;
			if (leftup >= 0) {
				if (result[i] == leftup)
					return false;
			}
			if (rightup < n) {
				if (result[i] == rightup)
					return false;
			}
			--leftup;
			++rightup;
		}
		return true;
	}

	private void printQueues(int[] result) {
		for (int row = 0; row < n; ++row) {
			for (int column = 0; column < n; ++column) {
				if (result[row] == column) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

//	public List<List<String>> solveNQueens(int n) {
//        
//    }

}
