//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_295 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    1. Recursion 前序遍历：根，左，右
//    复杂度分析
//      时间复杂度：O(n)。递归函数 T(n) = 2T(n/2) + 1
//      空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logN)。
    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {

            if (root != null) {
                res.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
            return res;
        }
    }
}
