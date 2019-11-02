/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// class Solution {
// public:
//     vector<int> preorderTraversal(TreeNode* root) {
//         vector<int> v;
//         preTraversal(root, v);
//         return v;
// }
//     void preTraversal(TreeNode* root, vector<int>& v){
//         if(!root) return;
//         v.push_back(root->val);
//         preTraversal(root->left, v);
//         preTraversal(root->right, v);
//     }
// };

// class Solution {
// public:
//     vector<int> preorderTraversal(TreeNode* root) {
//         vector<int> v;
//         if(!root) return v;
//         TreeNode* temp = root;
//         stack<TreeNode*> s;
//         s.push(root);
//         while(!s.empty()){
//             temp = s.top();
//             s.pop();
//             v.push_back(temp->val);
//             if(temp->right) s.push(temp->right);
//             if(temp->left) s.push(temp->left);
//         }
//         return v;
//     }
// };

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> v;
        if(!root) return v;
        TreeNode* temp = root, *prev;
        while(temp){
            if(!temp->left){
                v.push_back(temp->val);
                temp = temp->right;
            }else{
                prev = temp->left;
                while(prev->right&&(prev->right != temp))
                    prev = prev->right;
                if(!prev->right){
                    v.push_back(temp->val);
                    prev->right = temp;
                    temp = temp->left;
                }else{
                    prev->right = NULL;
                    temp = temp->right;
                }
            }
        }
        return v;
    }
};
// @lc code=end

