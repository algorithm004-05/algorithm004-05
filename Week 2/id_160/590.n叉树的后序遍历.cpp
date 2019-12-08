/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
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
    vector<int> postorder(Node* root) {
        if(root==NULL) return {};
        vector<int> res;
        stack<Node*> s;
        s.push(root);
        while(!s.empty())
        {
            Node* temp=s.top();
            s.pop();
            for(int i=0;i<temp->children.size();i++) s.push(temp->children[i]);
            res.push_back(temp->val);
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
// @lc code=end

