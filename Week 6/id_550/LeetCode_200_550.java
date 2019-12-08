class Solution {
    private static final int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
         
        int rows = grid.length;  
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols); 
        
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {
                    uf.count++;
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols + j;
                            int id2 = x*cols + y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;   
    }
    
    class UnionFind { 
	    public int count = 0; 
	    private int[] parent; 
	    public UnionFind(int n) { 
		    parent = new int[n]; 
		    for (int i = 0; i < n; i++) { 
			    parent[i] = i;
		    }
	    } 
        
	    public int find(int p) { 
		    while (p != parent[p]) { 
			    parent[p] = parent[parent[p]]; 
			    p = parent[p]; 
		    }
		    return p; 
	    }
        
	    public void union(int p, int q) { 
		    int rootP = find(p); 
		    int rootQ = find(q); 
		    if (rootP == rootQ) return; 
		    parent[rootP] = rootQ; 
		    count--;
	    }
    }
}
