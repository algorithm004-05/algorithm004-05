

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebParam.Mode;

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
public class LeetCode_145_510 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root,List list){
        if(null == root){
           return;
        }
        if(null != root.left){
            helper(root.left, list);
        }
        if(null != root.right){
            helper(root.right, list);
        }
        list.add(root.val);
    }

    /**
     * 栈  前序遍历反向处理  从右向左 链表反向加入
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(null != node || !stack.empty()){
            if(null != node){
                list.addFirst(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop().left;
            }
        }
        return list;
    }
}
