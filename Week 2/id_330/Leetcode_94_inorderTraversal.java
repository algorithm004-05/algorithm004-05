import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94_inorderTraversal {

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     */
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        helper(root, res);
        return res;
    }

    /**
     * 递归调用，树结构
     */
    public void helper(TreeNode root, List res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 前中后续遍历使用栈结构操作,中序遍历，顺序依次：左中后，压栈顺序即为根左，么有左结点开始弹栈保存，将右压栈。。。
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode c = root;
        while (c != null || !stack.isEmpty()) {
            while (c != null) {
                stack.push(c);
                c = c.left;
            }
            c = stack.pop();
            res.add(c.val);
            c = c.right;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
