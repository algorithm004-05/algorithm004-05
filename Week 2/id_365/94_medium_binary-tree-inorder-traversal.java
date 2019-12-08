/**
 *  给定一个二叉树，返回它的中序 遍历。
 *
 *  示例:
 *
 *  输入: [1,null,2,3]
 *     1
 *     \
 *      2
 *     /
 *       3
 *
 *  输出: [1,3,2]
 *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer >  list = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            res.add(treeNode.val);
            treeNode = treeNode.right;
        }
        return res;
    }
}