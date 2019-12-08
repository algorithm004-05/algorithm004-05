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



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List < Integer > res = new ArrayList < > ();
//        helper(root, res);
//        return res;
//    }
//    public void helper(TreeNode root, List < Integer > res) {
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                helper(root.right, res);
//            }
//        }
//    }
public List < Integer > inorderTraversal(TreeNode root) {
    List < Integer > res = new ArrayList < > ();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
        if (curr.left == null) {
            res.add(curr.val);
            curr = curr.right;
        } else {
            pre = curr.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = curr;
            TreeNode temp = curr;
            curr = curr.left;
            temp.left = null;
        }
    }
    return res;
}

}
//leetcode submit region end(Prohibit modification and deletion)
