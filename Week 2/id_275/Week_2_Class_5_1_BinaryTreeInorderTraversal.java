//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：二叉树的中序遍历
public class Week_2_Class_5_1_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Week_2_Class_5_1_BinaryTreeInorderTraversal().new Solution();
        TreeNode rootNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);

        rootNode.right = treeNode2;
        treeNode2.left = treeNode3;
        rootNode.left = treeNode4;
        treeNode4.right = treeNode5;

        List<Integer> result = new ArrayList<>();
        result = solution.inorderTraversal(rootNode);
        result.forEach(System.out::println);
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
//deletion/**
// Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        private void helper(TreeNode node, List<Integer> result) {
            if (node.left != null) {
                helper(node.left, result);
            }

            result.add(node.val);

            if (node.right != null) {
                helper(node.right, result);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}