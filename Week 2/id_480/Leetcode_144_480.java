//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

import java.util.ArrayList;
import java.util.List;

public class Leetcode_144_480 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Leetcode_144_480().new Solution();
        System.out.println(solution.preorderTraversal(root));

    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> integers = new ArrayList<>();
            if (root == null) {
                return integers;
            }
            preOrder(root, integers);
            return integers;
        }

        void preOrder(TreeNode node, List<Integer> integers) {
            if (node != null) {
                integers.add(node.val);
            }
            if (node.left != null) {
                preOrder(node.left, integers);
            }
            if (node.right != null) {
                preOrder(node.right, integers);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}