package leetcode.jacf.tech;

/**
 * @author jacf
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        walk(root, p, q);
        return ans;
    }

    private boolean walk(TreeNode current, TreeNode p, TreeNode q) {
        if (current != null) {
            int left = walk(current.left, p, q) ? 1 : 0;
            int right = walk(current.right, p, q) ? 1 : 0;
            int mid = (current == p || current == q) ? 1 : 0;
            if (left + right + mid >= 2) {
                ans = current;
            }
            return (left + right + mid > 0);
        }

        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
