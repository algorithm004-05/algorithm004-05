/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */
public class LeetCode_98_100 {

    /**
     * 二叉搜索树定义为 左 < 中 < 右
     * 根据中序遍历过程中如果发现当前结点小于等于前面的结点，那么就代表其非二叉搜索树
     * ------------------------------------
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre != null && pre.val >= node.val) {
                return false;
            }
            pre = node;
            root = node.right;
        }
        return true;
    }

}