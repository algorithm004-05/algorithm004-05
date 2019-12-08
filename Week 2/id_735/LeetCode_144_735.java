import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (62.12%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    46.8K
 * Total Submissions: 75.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List <Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper (TreeNode root, List <Integer> list) {

        if (root == null) return;
        list.add(root.val);
        if (root.left != null) {
            helper(root.left, list);
        }
        if (root.right != null) {
            helper(root.right, list);
        }
    }
}
// @lc code=end

