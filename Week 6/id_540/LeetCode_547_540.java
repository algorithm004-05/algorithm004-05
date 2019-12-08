package com.company;

public class LeetCode_547_540 {
    public int findCircleNum(int[][] M) {
        DisjointSet disjointSet = new DisjointSet();
        int[] persons = new int[M.length];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = i;
        }
        disjointSet.makeSet(persons);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    disjointSet.unionSet(i, j);
                }
            }
        }

        return disjointSet.countRoots();
    }

    private class DisjointSet {
        private DisjointSetNode[] nodes;

        public void makeSet(int[] values) {
            nodes = new DisjointSetNode[values.length];
            for (int i = 0; i < values.length; i++) {
                DisjointSetNode node = new DisjointSetNode();
                node.setValue(values[i]);
                node.setParent(node);
                nodes[i] = node;
            }
        }

        public void unionSet(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) {
                return;
            }

            nodes[yRoot].setParent(nodes[xRoot]);
        }

        public int find(int x) {
            DisjointSetNode targetNode = nodes[x];
            if (targetNode == null) {
                return -1;
            }

            while (!targetNode.isParentOfItSelf()) {
                targetNode = targetNode.getParent();
            }

            return targetNode.getValue();
        }

        public int countRoots() {
            int count = 0;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].isParentOfItSelf()) {
                    count ++;
                }
            }

            return count;
        }

        private class DisjointSetNode {
            private DisjointSetNode parent;
            private int value;

            public DisjointSetNode getParent() {
                return parent;
            }

            public void setParent(DisjointSetNode parent) {
                this.parent = parent;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public boolean isParentOfItSelf() {
                return this == parent;
            }
        }
    }
}
