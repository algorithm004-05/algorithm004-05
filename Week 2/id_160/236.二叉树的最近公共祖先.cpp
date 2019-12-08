/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root || root == p || root == q) return root;

        unordered_map<TreeNode*, TreeNode*> parent;
        parent[root] = NULL;

        stack<TreeNode*> stk;
        stk.push(root);
        
        while (!parent[p] || !parent[q]) {
            TreeNode* node = stk.top(); stk.pop();
            if (node->left) {
                parent[node->left] = node;
                stk.push(node->left);
            } 
            if (node->right) {
                parent[node->right] = node;
                stk.push(node->right);
            }
        }
        
        set<TreeNode*> ancestor;
        while (p) {
            ancestor.insert(p);
            p = parent[p];
        }
        while (ancestor.find(q) == ancestor.end()) {
            q = parent[q];
        }
        return q;
    }
};
// @lc code=end

