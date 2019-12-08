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

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树的前序遍历
public class Week_2_Class_6_2_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Week_2_Class_6_2_BinaryTreePreorderTraversal().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}