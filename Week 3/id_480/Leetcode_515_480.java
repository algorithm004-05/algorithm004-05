package leetcode.editor.cn;  //您需要在二叉树的每一行中找到最大的值。
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_515_480 {
    public static void main(String[] args) {

        Solution solution = new Leetcode_515_480().new Solution();

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

        private Queue<TreeNode> queue = new LinkedList<>();

        public List<Integer> largestValues(TreeNode root) {
            List<Integer> maxInLevel = new ArrayList<>();
            if (root == null) {
                return maxInLevel;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    int val = node.val;
                    if (val > max) {
                        max = val;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                maxInLevel.add(max);
            }

            return maxInLevel;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}