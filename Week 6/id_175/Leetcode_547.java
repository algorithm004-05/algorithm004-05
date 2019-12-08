package week6;

/**
 * @author shizeying
 * @date 2019/12/1 22:23
 * @description
 */
public class Leetcode_547 {

  public int findCircleNum(int[][] M) {
    int[] visited = new int[M.length];
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      if (visited[i] == 0) {
        _getDfs(M, visited, i);
        count++;
      }
    }
    return count;
  }

  public void _getDfs(int[][] M, int[] visited, int i) {
    for (int j = 0; j < M.length; j++) {
      if (M[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        _getDfs(M, visited, j);
      }
    }
  }
}
