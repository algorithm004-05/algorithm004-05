/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
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
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> nodes;
        std::stack<TreeNode*> s;
        while(1) {
            while(root) { s.push(root); root=root->left; }
            if(s.empty()) break;
            root=s.top(); s.pop();
            nodes.push_back(root->val);
            root=root->right;
        }
        return nodes;
    }
};

// class Solution {
// public:
//     vector<int> inorderTraversal(TreeNode* root) {
//         stack<TreeNode> s;
//         vector<int> nodes;
//         TreeNode* t = root;
//         while(t || !s.empty()){
//             while(t){  //遍历到最左边的叶结点
//                 s.push(*t);
//                 t = t->left;
//             }
//             if(!s.empty()){
//                 nodes.push_back(s.top().val);
//                 t = s.top().right;
//                 s.pop();
//             }
//         }
//         return nodes;
//     }
// };

// @lc code=end

