package geekbang.myleetcode.week02;

import geekbang.myleetcode.TreeNode;

public class LeetCode_236_420 {



    /**
     * 递归
     * 高分题解
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (null == left) {
                return right;
            }
            if (null == right) {
                return left;
            }
            return root;
        }
    }

    /**
     * 递归
     * 官方题解
     */
    class Solution_1 {
        private TreeNode ans;

        public Solution_1() {
            this.ans = null;
        }

        private boolean recurseTree(TreeNode curr, TreeNode p, TreeNode q) {
            if (null == curr) {
                return false;
            }

            int left = recurseTree(curr.left, p, q) ? 1 : 0;

            int right = recurseTree(curr.right, p, q) ? 1 : 0;

            int middle = (curr == p || curr == q) ? 1 : 0;

            if (left + right + middle >= 2) {
                this.ans = curr;
            }

            return left + right + middle > 0;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recurseTree(root, p, q);
            return this.ans;
        }
    }
}
