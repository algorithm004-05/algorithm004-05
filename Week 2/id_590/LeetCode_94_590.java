package homework.week2;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class LeetCode_94_590 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }


}
