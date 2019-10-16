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
//solution1
// void insert(struct ListNode* p,int val){
//     p->next=malloc(sizeof(struct ListNode));
//     (p->next)->val=val;
// }
// struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
// struct ListNode* mergeList=malloc(sizeof(struct ListNode));

// struct ListNode* head=mergeList;
// if (l1->val>l2->val){
// head->val=l2->val;
// l2=l2->next;
// }else {
//     head->val=l1->val;
//     l1=l1->next;
// }

// while (l1&&l2)
// {
//     if (l1->val>l2->val)
//     {
//         // mergeList->next=head2;
//         insert(mergeList,l2->val);
//         mergeList=mergeList->next;
//         l2=l2->next;
//     }else
//     {
//         insert(mergeList,l1->val);
//         mergeList=mergeList->next;
//         // mergeList->next=head1;
//         l1=l1->next;
//     }
    
// }

// if (l1==NULL&&l2 !=NULL){
//     while (l2)
//     {
//     insert(mergeList,l2->val);
//     mergeList=mergeList->next;
//     l2=l2->next;
//     }
// }else if (l2==NULL&&l1 !=NULL){
//         while (l1)
//     {
//     insert(mergeList,l1->val);
//     mergeList=mergeList->next;
//     l1=l1->next;
//     }
// }

// return head;
// }
///solution2
// struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
//     struct ListNode head,*p1,*p2;
//     head.next=l1;
//     l1=&head;
//     // int a=0,b=0;
//     while (l2)
//     {
//         p1=l1->next;
//         p2=l2->next;
//         if (p1==NULL)
//         {
//             l1->next=l2;
//             break;
//         }
        

//         if((p1->val) > (l2->val)){
        
//             l1->next=l2;
//             l1->next->next=p1;
//             l2=p2;
//         }else
//         {
//             l1=l1->next;
//         }
        
//     }
    

//     return head.next;
// }
//solution3
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1==NULL) return l2;
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
// @lc code=end
