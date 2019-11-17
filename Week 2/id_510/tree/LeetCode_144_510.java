

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.scene.Node;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 *   \
 *    2
 *  /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_144_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root,List list){
        if(null == root){
           return;
        }
        list.add(root.val);
        if(null != root.left){
            helper(root.left, list);
        }
        if(null != root.right){
            helper(root.right, list);
        }
    }

    /**
     * 栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(null != node || !stack.empty()){
            if(null != node){
                // 跟节点直接添加
                list.add(node.val);
                stack.push(node);
                // 遍历左边
                node = node.left;
            } else {
                // 遍历右边
                node = stack.pop().right;
            }
        }
        return list;
    }
}
