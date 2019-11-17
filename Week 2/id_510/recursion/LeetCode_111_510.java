import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * 给定一个二叉树，找出其最小深度。
 *
 *  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 *
 *  示例:
 *
 *  给定二叉树 [3,9,20,null,null,15,7],
 *
 *  3
 *  / \
 *  9  20
 *  /  \
 *  15   7
 *  返回它的最小深度  2.
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_111_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *  递归
     *  左右子节点都不存在
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        // 无子节点 则返回深度1
        if (null == root.left && null == root.right) {
            return 1;
        }
        // 左节点最浅
        int leftMin = minDepth(root.left);
        // 右节点最浅
        int rightMin = minDepth(root.right);
        // 无左节点 则返回右节点深度
        if (leftMin == 0) {
            return rightMin + 1;
        }
        // 无右节点 则返回左节点深度
        if (rightMin == 0) {
            return leftMin + 1;
        }
        // 返回一个最小深度
        return Math.min(leftMin, rightMin) + 1;
    }

    /**
     * 递归优化
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftMin = minDepth2(root.left);
        int rightMin = minDepth2(root.right);
        return (0 == leftMin || 0 == rightMin) ? (leftMin + rightMin + 1) : Math.min(leftMin, rightMin) + 1;
    }


     /**
     * 层序遍历
     *  左右子节点都不存在
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if(null == root){
            return 0;
        }
        int min  = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            min++;
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(null == node.left && null == node.right){
                    return min;
                } 
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
        }
        return min;
    }
}
