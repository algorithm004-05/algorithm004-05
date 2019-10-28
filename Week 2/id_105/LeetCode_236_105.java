package id_105;

public class LeetCode_236_105 {


    /**
     * 1) 在左右子树中分别查找p / q.
     * 如果左子树包含p， 右子树包含q
     * 或者左子树包含q， 右子树包含p
     * 此时的最近公共节点就是最近公共祖先。
     * <p>
     * 2）如果左子树包含p/q， 那么到root.left 查找公共节点在左子树中。
     * 3) 如果右子树包含p/q， 那么到root.right 查找公共节点在右子树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;

    }

    private TreeNode ans;

    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }
}
