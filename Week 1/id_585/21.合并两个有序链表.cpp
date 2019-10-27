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
//双指针 
//class Solution {
//public:
//    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
//     ListNode dummy = ListNode(-1);
//     ListNode *pre = &dummy;
//     while (l1 != NULL && l2 != NULL){
//         if(l1->val < l2->val){
//             pre->next = l1;
//             l1 = l1->next;
//         }else{
//             pre->next = l2;
//             l2 = l2->next;
//         }
//             pre=pre->next;
//     }
//     pre->next = l1 != NULL ? l1 :l2;
//
//     return dummy.next;
//     
//    }
//};
//recursion
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2){

        if (l1 == nullptr)      return l2;
        else if (l2 == nullptr) return l1;
        else if (l1->val < l2->val){
            l1->next = mergeTwoLists( l1->next,  l2);
            return l1;
        }
        else {
            l2->next = mergeTwoLists( l2->next,  l1);
            return l2;
        }
    }
};
// @lc code=end

