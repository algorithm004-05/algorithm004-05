

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
  *翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_226_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 广度 层 队列
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(null == root){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){
                // 获取节点
                TreeNode node = queue.poll();
                //左节点存放队列
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
                // 交换左右节点
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }

    /**
     * 深度 前中后 递归 栈
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if(null == root){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

}
