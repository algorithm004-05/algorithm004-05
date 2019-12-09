/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) 
	{
        if(!root) return {};
        vector<vector<int>> res;
        queue<Node*> q;
        q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            vector<int> curLevel;
            for (int i = 0; i < size; i++)
            {
                Node* tmp = q.front();
                q.pop();
                curLevel.push_back(tmp -> val);
                for (auto n : tmp -> children)
                     q.push(n); 
            }
            res.push_back(curLevel); 
        }
        return res; 
    }
};
// @lc code=end

