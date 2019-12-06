

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_515_510 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        new LeetCode_515_510().largestValues(root);
    }
    public List<Integer> largestValues(TreeNode root) {
        return largestValuesD(root, new ArrayList<>(), 0);
    }
    public List<Integer> largestValuesB(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(null == root){
            return l;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node;
        while(q.size() > 0){
            int s = q.size();
            int max = Integer.MIN_VALUE;
            while(s-- > 0){
                node = q.poll();
                max = Math.max(node.val, max);
                if(null != node.left){
                    q.offer(node.left);
                }
                if(null != node.right){
                    q.offer(node.right);
                }
            }
            l.add(max);
        }
        return l;
    }

    public List<Integer> largestValuesD(TreeNode root,List<Integer> l,int index) {
        if(null == root){
            return l;
        }
        if(l.size() <= index){
            l.add(root.val);
        } else {
            l.set(index,Math.max(l.get(index), root.val));
        }
        index++;
        largestValuesD(root.left,l,index);
        largestValuesD(root.right,l,index);
        return l;
    }
}
