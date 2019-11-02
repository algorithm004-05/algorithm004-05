//给定一个二叉树，返回它的中序 遍历。
//
//示例:
//
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_295 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

//    1. Recursion 中序遍历：左，根，右
//    复杂度分析
//      时间复杂度：O(n)。递归函数 T(n) = 2T(n/2) + 1
//      空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logN)。

    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root != null) {
                inorderTraversal(root.left);
                res.add(root.val);
                inorderTraversal(root.right);
            }
            return res;
        }
    }
}
