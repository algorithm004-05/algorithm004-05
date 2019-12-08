/*
 * @lc app=leetcode.cn id=21 lang=c
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (57.59%)
 * Likes:    668
 * Dislikes: 0
 * Total Accepted:    125.7K
 * Total Submissions: 217.6K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// szh 2019-10-20

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *headNode,*pr;
    headNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    pr = headNode;
    if(l1 == NULL) pr->next =l2;
    else if(l2 == NULL ) pr->next =l1;
    else{
    while(l1 && l2){
        if( l1->val < l2->val ){
            pr->next = l1;
            pr =l1;
            l1 =l1 ->next;   
        }
        else{
            pr->next = l2;
            pr = l2;
            l2 = l2->next;
        }
        
    }
    pr->next = l1?l1:l2;
    }
    return headNode->next;
}


// @lc code=end

