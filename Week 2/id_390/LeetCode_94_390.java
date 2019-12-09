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
// 1. 递归  时间O(n)  空间O(logn)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root != null) { // 临界值判断
            if(root.left != null) { // 遍历左子树
                helper(root.left, list);
            }
            list.add(root.val);  // 添加根结点
            if(root.right != null) {
                helper(root.right, list);  // 遍历右子树
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
