package com.simon.leetcode.lcn236;

public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ans = null;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }


    //1.循环遍历root所有节点，看是否能够找到对应节点p和q，找到则往上找到共同最深父节点，否则返回空
    //2.查找当前结点是否含有p或q其中一个，递归查左子树和右子树，一旦当两个都查到，则当前结点为p和q最近父节点。时间复杂度和空间复杂度均为O(N)。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
}
