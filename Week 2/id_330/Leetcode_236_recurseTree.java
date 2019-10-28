public class Leetcode_236_recurseTree {

    private TreeNode ans;

    public Leetcode_236_recurseTree() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // 递归出口
        if (currentNode == null) {
            return false;
        }
        // 逻辑处理，判断当前结点是否是其中一个值，是返回true
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }
        //
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
