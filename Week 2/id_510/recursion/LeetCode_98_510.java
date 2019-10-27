import java.util.Stack;


/**
 *
 *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_98_510 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 查找不符合规则的返回false
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    /**
     * 递归 理解的不深 需要多想想
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    private boolean helper(TreeNode root,Integer lower, Integer upper){
        if(null == root){
            return true;
        }
        int val =root.val;
        if(null != lower && val <= lower) return false;
        if(null != upper && val >= upper) return false;
        if(!helper(root.left, lower, val)) return false;
        if(!helper(root.right, val, upper)) return false;
        return true;
    }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root){
        if(null == root){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root,pre = null;
        while(null != node || !stack.empty()){
            while(null != node){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(null != pre && pre.val >= node.val){
                return false;
            }
            pre = node;
            node = node.right;
        }
        return true;
    }
}
