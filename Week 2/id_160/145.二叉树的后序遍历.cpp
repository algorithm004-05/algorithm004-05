/*
 * @lc app=leetcode.cn id=145 lang=cpp
 *
 * [145] 二叉树的后序遍历
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
//     vector<int> postorderTraversal(TreeNode* root) {
//         vector<int> nodes;
//         postorder(root, nodes);
//         return nodes;
//     }
// private:
//     void postorder(TreeNode* root, vector<int>& nodes) {
//         if (!root) {
//             return;
//         }
//         postorder(root -> left, nodes);
//         postorder(root -> right, nodes);
//         nodes.push_back(root -> val);
//     }
// };

// class Solution {
// public:
//     vector<int> postorderTraversal(TreeNode* root) {
//         vector<int> nodes;
//         stack<TreeNode*> todo;
//         TreeNode* last = NULL;
//         while (root || !todo.empty()) {
//             if (root) {
//                 todo.push(root);
//                 root = root -> left;
//             } else {
//                 TreeNode* node = todo.top();
//                 if (node -> right && last != node -> right) {
//                     root = node -> right;
//                 } else {
//                     nodes.push_back(node -> val);
//                     last = node;
//                     todo.pop();
//                 }
//             }
//         }
//         return nodes;
//     }
// };

// class Solution {
// public:
//     vector<int> postorderTraversal(TreeNode* root) {
//         vector<int> nums;
//         TreeNode* cur = nullptr;

//         while (root) {
//             if (root->right) {
//                 cur = root->right;
//                 while (cur->left && cur->left != root) {
//                     cur = cur->left;
//                 }
//                 if (cur->left == root) {
//                     cur->left = nullptr;
//                     root = root->left;
//                 } else {
//                     nums.push_back(root->val);
//                     cur->left = root;
//                     root = root->right;
//                 }
//             } else {
//                 nums.push_back(root->val);
//                 root = root->left;
//             }
//         }
//         return vector<int>(nums.rbegin(), nums.rend());
//     } 
// }

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root == NULL) return result;
        stack<TreeNode*> todo;
        todo.push(root);
        while(!todo.empty()) {
            auto cur = todo.top();
            result.push_back(cur->val);
            todo.pop();
            if(cur->left) todo.push(cur->left);
            if(cur->right) todo.push(cur->right);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};
// @lc code=end

