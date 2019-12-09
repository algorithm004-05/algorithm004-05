import java.util.*;
/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 二叉树的中序遍历
 * 
 */
public class LeetCode_94_100 {
    /**
     * 方法一：使用递归，将当前结点放入集合中即可
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<String> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        ans.add(root);
        helper(root.right, ans);
    }


    /**
     * 方法二：使用迭代，手动创建栈模拟递归操作
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            root = node.right;
        }
        return ans;
    }
}