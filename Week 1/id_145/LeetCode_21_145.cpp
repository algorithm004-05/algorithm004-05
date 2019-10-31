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
        ListNode dummy_node(-1);
        ListNode* prev = &dummy_node;
        while(l1 && l2) {
            if (l1->val <= l2->val) {
                prev->next 
            }
        }
    }
};