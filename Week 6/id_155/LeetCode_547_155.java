class Solution {
   public int findCircleNum(int[][] M) {
        int n = M.length;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.count;
    }
    

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                count--;
            }
        }
    }
}