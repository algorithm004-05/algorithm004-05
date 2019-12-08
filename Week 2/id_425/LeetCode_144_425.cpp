/*
 * @lc app=leetcode.cn id=144 lang=cpp
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (62.00%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    46K
 * Total Submissions: 74K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
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
//szh 2019-10-25
#define CASE 0
#if CASE
//递归遍历
class Solution {
public:
    vector<int> retvec;//成员变量
    vector<int> preorderTraversal(TreeNode* root) {
        preTravel(root);
        return retvec;
}
    void preTravel(TreeNode *root){
        if(root){
            retvec.push_back(root->val);
            preTravel(root->left);
            preTravel(root->right);
        }
    }
};
//-------------------------

#else
//栈方法
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if(!root) return vector<int>();
        stack<TreeNode*> st;
        vector<int> ret;
        TreeNode* p=root;
        while(p || !st.empty()) // 分为读取节点和读取栈两部分
        {
            while(p){
                ret.push_back(p->val);
                st.push(p);
                p=p->left;
            }
            p=st.top();
            st.pop();
            p=p->right;
        }
        return ret;
    }
};
#endif
// @lc code=end

