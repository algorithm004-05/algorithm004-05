package week2.Lesson6.Question144PreorderTraversalBinaryTree;


import week2.Lesson6.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public static void main(String[] args) {

        PreOrderTraversal pt = new PreOrderTraversal();
        ArrayList<Integer> order = pt.preOrderTraversal(TreeNode.getATree());
        System.out.println(order.toString());
    }

    /**
     * 递归，二叉树的前序遍历
     */
    public ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
