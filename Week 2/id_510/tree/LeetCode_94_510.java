

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
   1
    \
     2
    /
   3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_94_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        
    }
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root,List list){
        if(null == root){
            return;
        }

        // proceess 
        // 找当前节点最下面的左节点 一直找到最底层
        if(null != root.left){
            // drill down
             helper(root.left, list);
        }
        // 最左边的开始添加
        list.add(root.val);

        // proceess
        // 处理右节点 
        if(null != root.right){
            // drill down
            helper(root.right, list);
        }
        // restore current status
    }

    /**
     * 
     * 栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (null != node || !stack.empty()) {
            // 不为空 压入栈
            if (null != node) {
                stack.push(node);
                // 处理左节点
                node = node.left;
            } else {
                // 节点为空 弹出父节点
                node = stack.pop();
                // 添加父节点值
                list.add(node.val);
                // 处理父节点的右节点
                node = node.right;
            }
        }
        return list;
    }
}
