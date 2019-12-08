class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) 
        return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        
        if(root.left != null)
            preorderTraversal(root.left, list);
        if(root.right != null)
            preorderTraversal(root.right, list);
        
        return list;
    }
}

