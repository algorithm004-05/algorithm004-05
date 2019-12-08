/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1==NULL)
            return l2;
        if(l2==NULL) return l1;
        if(l2->val > l1->val){
            l1->next=mergeTwoLists(l1->next,l2);
            return l1;
        }else
        {
            l2->next=mergeTwoLists(l1,l2->next);
            return l2;
        }
        
        
    }
};
// @lc code=end

