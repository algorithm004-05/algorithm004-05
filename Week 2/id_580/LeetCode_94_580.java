class Solution {
    public List <Integer> inorderTraversal(TreeNode root) {
        List <Integer> result = new ArrayList < > ();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List < Integer > result) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }
}

