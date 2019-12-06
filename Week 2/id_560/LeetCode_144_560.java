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
    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                lists.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return lists;
    }
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                lists.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
