package com.geek.lee.leetcode.medium;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import com.geek.lee.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal_94 {

    // 定义一个返回结果集.
    List<Integer> result = new ArrayList<>();
    // 用于栈的实现方式的全局变量
    Stack<TreeNode> stack = new Stack<>();
    /**
     * 递归实现二叉树中序遍历
     * 该种方式最常规.复杂度稍高
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归遍历
//        inorderTraversal(root, result);
        // 栈方式遍历
        inorderTraversalByStack(root);
        // 返回结果集
        return result;
    }

    /**
     * 递归遍历的具体实现.
     * 中序遍历顺序:
     *  1. 左子树
     *  2. 根
     *  3. 右子树
     * @param root
     * @param result
     */
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        // 递归终止条件. 当root为空时,终止递归
        if (null == root) {
            return;
        }

        if (root.left != null) {
            inorderTraversal(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right, result);
        }
    }

    /**
     * 中序遍历栈的方式实现
     * 手动模拟一个方法栈,将每次遍历的元素压栈;
     * 当遍历到末尾, 弹出栈顶元素.
     * @param root
     */
    private void inorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
}
