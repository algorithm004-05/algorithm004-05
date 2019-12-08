package com.geek.lee.leetcode.medium;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import com.geek.lee.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal_144 {
    // 返回结果集
    List<Integer> result = new ArrayList<>();
    // 用于栈的实现方式的全局变量
    Stack<TreeNode> stack = new Stack<>();

    /**
     * 递归遍历,同中序遍历.递归时调整左右根顺序即可
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归遍历
//        preorderTraversal(root, result);
        // 栈的方式遍历
        inorderTraversalByStack(root);
        return result;
    }

    /**
     * 递归遍历具体实现
     * 前序遍历书序:
     *  1. 根
     *  2. 左子树
     *  3. 右子树
     * @param root
     * @param result
     */
    private void preorderTraversal(TreeNode root, List<Integer> result) {
        // 递归终止条件
        if (null == root) {
            return;
        }

        result.add(root.val);

        if (null != root.left) {
            preorderTraversal(root.left, result);
        }

        if (null != root.right) {
            preorderTraversal(root.right, result);
        }
    }

    /**
     * 前序遍历栈的方式实现
     * 手动模拟一个方法栈,将每次遍历的元素压栈;
     * 当遍历到末尾, 弹出栈顶元素.
     * @param root
     */
    private void inorderTraversalByStack(TreeNode root) {
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            stack.push(cur);
            while (cur != null) {
                if (null != cur.right) {
                    stack.push(cur.right);
                    cur = cur.right;
                }
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
    }
}
