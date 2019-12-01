package com.neutorn.algorithm;

public class LeetCode_547 {

    public int findCircleNum(int[][] m) {
        int n = m.length;
        // 1.初始化并查集
        FindUnion findUnion = new FindUnion(n);
        // 2.合并并查集
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if(m[i][j] == 1) {
                    findUnion.union(i, j);
                }
            }
        }
        return findUnion.getCount();
    }
}

class FindUnion {
    private int count;
    private int[] parent;

    // 1.并查集的创建
    public FindUnion (int n) {
        this.count = n;
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    // 2.并查集的查询
    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
            parent[p] = parent[parent[p]];
        }
        return p;
    }

    // 3.合并数据
    public int union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
            count --;
        }
        return count;
    }

    public int getCount () {
        return count;
    }
}
