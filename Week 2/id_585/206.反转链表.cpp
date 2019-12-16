/*
 * @lc app=leetcode.cn id=206 lang=cpp
 *
 * [206] 反转链表
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
//class Solution {
//public:
//    ListNode* reverseList(ListNode* head) {
//       ListNode *prev = nullptr;
//       ListNode *curr = head, *next;
//        while(curr != nullptr ){
//            next = curr->next;
//            curr->next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//};
//class Solution {
//public:
//    ListNode* reverseList(ListNode* head) {
//        if (!head || !(head -> next)) {
//            return head;
//        }
//        ListNode* node = reverseList(head -> next);
//        head -> next -> next = head;
//        head -> next = NULL;
//        return node;
//    }
//};
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head==nullptr || head->next == nullptr) return head;
        ListNode* p = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr; //the first node should point to null after the reverse.
        return p;
    }
};
// @lc code=end

