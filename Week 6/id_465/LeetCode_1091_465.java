package leetcode.jacf.tech;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 *
 * @author jacf
 */
public class ShortestPathInBinaryMatrix {
    class Solution {
        private class Node {
            int i;
            int j;

            public Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
                return -1;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 0));
            int i, j, count = 1;
            Node newest = queue.peek();
            Node last = newest;
            int[][] a = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                i = node.i;
                j = node.j;
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    return count;
                }
                for (int k = 0; k < a.length; k++) {
                    i += a[k][0];
                    j += a[k][1];
                    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0) {
                        Node temp = new Node(i, j);
                        queue.offer(temp);
                        newest = temp;
                        grid[i][j] = -1;
                    }
                    i -= a[k][0];
                    j -= a[k][1];
                }
                if (node == last) {
                    last = newest;
                    count++;
                }
            }
            return -1;

        }
    }

}
