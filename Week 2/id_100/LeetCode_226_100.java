/**
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 * 旋转二叉树
 */
public class LeetCode_226_100 {

    /**
     * 使用递归法
     * 拆分子问题，把每个结点的左右结点兑换即可
     * -------------------------------------
     * 时间复杂度：每个结点都需要遍历一遍，时间复杂度为O(N)
     * 空间复杂度：同理为O(N)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}