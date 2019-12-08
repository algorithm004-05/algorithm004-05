package week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther: shizeying
 * @date: 2019/11/4 00:32
 * @description:
 */
public class leetcode_200 {
	/**
	 * 200
	 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
	 * 示例 1:
	 * 输入:
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * 输出: 1
	 * <p>
	 * 示例 2:
	 * 输入:
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * 输出: 3
	 * <p>
	 * Related Topics 深度优先搜索 广度优先搜索 并查集
	 */
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfsNumIslands(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private void bfsNumIslands(char[][] grid, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] cur = queue.remove();
			i = cur[0];
			j = cur[1];
			if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
				grid[i][j] = '0';
				queue.add(new int[]{i + 1, j});
				queue.add(new int[]{i -1, j});
				queue.add(new int[]{i , j+1});
				queue.add(new int[]{i , j-1});
			}
		}
	}
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfsNumIslands(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	private void dfsNumIslands(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfsNumIslands(grid,i+1,j);
		dfsNumIslands(grid,i,j+1);
		dfsNumIslands(grid,i-1,j);
		dfsNumIslands(grid,i,j-1);
	}
}
