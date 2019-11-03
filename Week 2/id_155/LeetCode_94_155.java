class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(null != curr || !stack.isEmpty()){
            while(null != curr){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}