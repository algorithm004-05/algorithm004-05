//1.二叉树的中序遍历
/**
 *Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
*/
class Solution {
public:
vector<int> inorderTraversal(TreeNode* root) {

    if (root==NULL){return pnext;}
    else {
        inorderTraversal(root->left);
    pnext.push_back(root->val);
    inorderTraversal(root->right);}
   
    return pnext;

}
private:
vector<int> pnext;
};

class Solution {
public:
    vector<int> res;
    vector<int> inorderTraversal(TreeNode* root) {
        if(root==NULL)
            return res;
        if(root->left!=NULL){
            inorderTraversal(root->left);
        }
        res.push_back(root->val);
        if(root->right !=NULL){
            inorderTraversal(root->right);
        }
        return res;
    }
};
