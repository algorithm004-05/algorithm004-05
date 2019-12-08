/**
虽然自己看了题解，不过，还是看明白代码了，我是弄清楚了代码才这样做的。
1，首先，我参考leetcode的第104题官方解法，递归的动画，明白了：
（1）对于8这个节点，mid是0，因为当前节点不等于p或q，而8这个节点的左右节点为null，故left 和right为0，
（2）对于9这个节点，虽然left和right都为0，但是mid为1，因为9等于给定的节点p。
那么：
（1）4这个节点的mid + left + right，自然等于mid + （8节点的mid + left + right） + （9节点的mid + left + right），于是等于1
（2）同理5节点的mid + left + right等于1，那么2节点的mid + left + right等于2。

虽然不想人肉递归，但是为了读懂还是进行了一下人肉递归。读懂代码业收获了不少呢。
*/

private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

