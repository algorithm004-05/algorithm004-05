import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import sun.net.www.content.audio.basic;

/**
 *
 *给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_104_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            max++;
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(null !=node.left){
                    queue.offer(node.left);
                }

                if(null !=node.right){
                    queue.offer(node.right);
                }
            }
        }
        return max;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(null == root){
            return 0;
        }
        // 左子树 和 右子树最大值
       int leftMax =  maxDepth1(root.left);
       int rightMax =  maxDepth1(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
