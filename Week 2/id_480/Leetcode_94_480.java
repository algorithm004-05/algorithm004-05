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

import java.util.ArrayList;
import java.util.List;

public class Leetcode_94_480 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Leetcode_94_480().new Solution();
        List<Integer> traversal = solution.inorderTraversal(root);
        System.out.println(traversal);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
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
            List<Integer> integers = new ArrayList<>();
            if (root == null) {
                return integers;
            }
            inOrder(root, integers);
            return integers;
        }

        void inOrder(TreeNode node, List<Integer> integers) {
            if (node.left != null) {
                inOrder(node.left, integers);
            }
            integers.add(node.val);
            if (node.right != null) {
                inOrder(node.right, integers);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}