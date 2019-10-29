class Solution {
public:
    int pre_index = 0;
    map<int, int> inorder_map;    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty()) {
            return nullptr;
        }        
        
        for (int i=0; i<inorder.size(); ++i) {
            inorder_map.insert(make_pair(inorder[i], i));
        }
        
        return buildTree(preorder, inorder, 0, preorder.size());
        
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder, int start, int end) {
        if (start == end) {
            return nullptr;
        }
        
        int val = preorder[pre_index++];
        int inorder_index = inorder_map[val];
        TreeNode* root = new TreeNode(val);
        root->left = buildTree(preorder, inorder, start, inorder_index);
        root->right = buildTree(preorder, inorder, inorder_index+1, end);
        return root;    
    }
};