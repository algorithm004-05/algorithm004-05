/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 *      输入: [1,null,2,3]
 *         1
 *          \
 *          2
 *         /
 *        3
 *      输出: [1,2,3]
 */

public class Leetcode_144_450 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return res;
    }
}