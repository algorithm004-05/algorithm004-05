class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        FindUnion fu = new FindUnion(n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(M[i][j] == 1) {
                    fu.union(i,j);
                }
            }
        }
        return fu.count();
    }
}

class FindUnion {
    private int count;
    private int[] parent;

    FindUnion(int n) {
        count = n;
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int m, int n) {
        int rootP = find(m);
        int rootQ = find(n);
        if(rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public int count() {
        return count;
    }
}