class Solution {
    
    public int numIslands(char[][] grids) {

  int count = 0;
  for (int i = 0; i < grids.length; i++) {
    for (int j = 0; j < grids[i].length; j++) {
      if (grids[i][j] == '1') {
        explore(grids, i, j);
        count++;
      }
    }
  }

  return count;

}

private void explore(char[][] grids, int i, int j) {

  if (grids[i][j] != '1') {
    return;
  }
  grids[i][j] = '2';

  List<Integer> iList = new ArrayList<>();
  List<Integer> jList = new ArrayList<>();
  iList.add(i);
  jList.add(j);

  while (!iList.isEmpty()) {
    i = iList.remove(0);
    j = jList.remove(0);

    int[][] adj = new int[][]{
          new int[]{i + 1, j},
          new int[]{i - 1, j},
          new int[]{i, j + 1},
          new int[]{i, j - 1}
        };

    for (int[] ij : adj) {
      if (ij[0] >= 0 && ij[0] < grids.length && ij[1] >= 0 && ij[1] < grids[ij[0]].length) {
        if (grids[ij[0]][ij[1]] == '1') {
          grids[ij[0]][ij[1]]++;
          iList.add(ij[0]);
          jList.add(ij[1]);
        }
      }
    }

  }
}

    
    public int numIslands_old(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    change(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void change(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = '2';
        change(grid, i + 1, j);
        change(grid, i - 1, j);
        change(grid, i, j + 1);
        change(grid, i, j - 1);
    }
}
