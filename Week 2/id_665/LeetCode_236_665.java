//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

//    private TreeNode ans;
//
//    public Solution() {
//        // Variable to store LCA node.
//        this.ans = null;
//    }
//
//    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
//
//
//        // If reached the end of a branch, return false.
//        if (currentNode == null) {
//            return false;
//        }
//
//        // process logic in current level
//        // drill down
//        // Left Recursion. If left recursion returns true, set left = 1 else 0
//        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
//
//        // Right Recursion
//        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
//
//        // If the current node is one of p or q
//        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
//
//        // restore current status
//        // If any two of the flags left, right or mid become True
//        if (mid + left + right >= 2) {
//            this.ans = currentNode;
//        }
//
//        // Return true if any one of the three bool values is True.
//        return (mid + left + right > 0);
//
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // Traverse the tree
//        this.recurseTree(root, p, q);
//        return this.ans;
//    }


    private TreeNode recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        // recursion terminator
        // 分情况讨论
        // root 子树中同时包含p和q, 返回root
        // root 中只有p, 返回p
        // root 中只有q, 返回q
        // root 中既没有p, 也没有q, 返回null
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/

        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        // drill down
        // 一个root节点，如果p，q分别在两侧，则回返回左右值。
        TreeNode left = recurseTree(root.left, p, q);
        TreeNode right = recurseTree(root.right, p, q);


        // process logic in current level
        // restore current status

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        }
        return right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        return recurseTree(root, p, q);


    }

}
//leetcode submit region end(Prohibit modification and deletion)
