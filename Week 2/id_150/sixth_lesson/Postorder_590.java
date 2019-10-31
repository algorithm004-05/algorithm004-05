package com.geek.lee.leetcode.easy;

import com.geek.lee.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :

 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 590. n叉树的后序遍历
 */
public class Postorder_590 {
    // 树遍历结果集
    List<Integer> result = new ArrayList<>();

    /**
     * 递归法遍历
     * n叉树的后序遍历
     * n叉也好, 二叉也好. 方式是一样的
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(n)
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        // 递归遍历
        postorder(root, result);
        // 返回结果
        return result;
    }

    /**
     * 递归遍历的具体实现
     * 后序遍历顺序:
     * 1. 左子树
     * 2. 右子树
     * 3. 根.
     * @param root
     * @param result
     */
    private void postorder(Node root, List<Integer> result) {
        if (null == root) {
            return;
        }

        if (null != root.children && root.children.size() > 0) {
            for (Node node : root.children) {
                postorder(node, result);
            }
        }

        result.add(root.val);
    }
}
