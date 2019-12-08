/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.09%)
 * Likes:    298
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 90.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
// class Solution {
// public:
//     vector<vector<int>> levelOrder(TreeNode* root) {
//        vector<vector<int>> levels;
//        hepler(root,0,levels);
//        return levels;
//     }
//     void hepler(TreeNode *root, int n,vector<vector<int>> &levels){
//         if (!root) return;
//         if(n>=levels.size()) levels.push_back(vector<int>{});//匿名vector
//         levels[n].push_back(root->val);
//         hepler(root->left,n+1,levels);
//         hepler(root->right,n+1,levels);
     
//     }
// };
//广度优先遍历:使用队列，将每层上的所有节点压入队列中，出队列依次提取各节点
//广度优先搜素无法使用递归，广度优先搜素无法记录层数
//记录层数的广度优先搜索。使用两个队列，每一层将节点进入队列，将队列节点赋值给另一个队列，队列里所有节点的子节点进入队列
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> levels;
        if(!root) return levels;
        queue<TreeNode> temp;
        temp.push(*root);
        while (!temp.empty()){
            queue<TreeNode> tem = temp;
            temp=queue<TreeNode>();
            cout << temp.size() << endl;
            vector<int> level;
            while (!tem.empty()){
                level.push_back(tem.front().val);
                if(tem.front().left) temp.push(*(tem.front().left));
                if(tem.front().right) temp.push(*(tem.front().right));
                tem.pop();
            }
            levels.push_back(level);
            cout << temp.size() << "----------------"<<endl;
        }
        return levels;
    }
};
// @lc code=end

