package id_105;

public class LeetCode_104_105 {

    public int maxDepth(TreeNode root) {

        return depth(root, 0);
    }

    public int depth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        int ldep = depth(root.left, depth + 1);
        int rdep = depth(root.right, depth + 1);
        return ldep > rdep ? ldep : rdep;
    }


}
