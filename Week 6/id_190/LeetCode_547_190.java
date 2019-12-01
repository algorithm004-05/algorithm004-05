
public class FriendCircles {


    class Solution {
        public int findCircleNum(int[][] M) {
            int height = M.length;
            if (height == 0) return 0;
            int width = M[0].length;
            if (width == 0) return 0;

            UnionFind uf = new UnionFind(height * width);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (M[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < height; i++) {
                if (uf.getParent()[i] == i) {
                    count++;
                }
            }

            return count;
        }

    }


    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
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

        public void union(int x, int y) {
            int p = find(x);
            int q = find(y);
            if (p == q) return;
            parent[p] = q;
            count--;
        }

        public int[] getParent() {
            return parent;
        }
    }


}

