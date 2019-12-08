/*
 * @lc app=leetcode.cn id=21 lang=c
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/*

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *head;
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;

    head = l1->val <= l2->val ? l1 : l2;
    struct ListNode *p1 = head;
    struct ListNode *p2 = head == l1 ? l2 : l1;

    struct ListNode *pre;
    while(p1 && p2){
        while(p1 && p1->val <= p2->val){
            pre = p1;
            p1 = p1 ->next;
        }
        pre -> next = p2;
        if(p1){
            while(p2 && p2->val <= p1->val){
                pre = p2;
                p2 = p2 -> next;
            }
            pre -> next = p1;
        }
    }
    return head;

}
*/
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;
    struct ListNode *pre;
    struct ListNode preHead;
    pre = &preHead;
    while(l1 && l2){
        if(l1->val <= l2->val){
            pre -> next = l1;
            l1 = l1 -> next;
        }
        else{
            pre -> next = l2;
            l2 = l2 -> next;
        }
        pre = pre -> next;
    }
    pre -> next = l1 == NULL ? l2 : l1;
    return preHead.next;
}
/*
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;
    if(l1->val <= l2->val){
        l1->next = mergeTwoLists(l2, l1->next);
        return l1;
    }
    else{
        l2->next = mergeTwoLists(l1, l2->next);
        return l2;
    }
}
*/
// @lc code=end

