// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
// https://leetcode-cn.com/merge-two-sorted-lists/
// https://leetcode.com/merge-two-sorted-lists/

// Question:
// 21. 合并两个有序链表
// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
// tip:
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

// Solution:
// 思路:用一个新的链表来起头，两个输入的链表做判断大小，加入其中

// 时间复杂度：O(N)
// 空间复杂度：O(1)

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    if (!l1) return l2;
    if (!l2) return l1;
    
    ListNode ret = ListNode(0);
    ListNode* cur = &ret;
    while (l1 && l2) {
        if (l1->val > l2->val) {
            cur->next = l2;
            l2 = l2->next;
        } else {
            cur->next = l1;
            l1 = l1->next;
        }
        cur = cur->next;
    }
    
    cur->next = l1 ? l1 : l2;
    
    return ret.next;
}

ListNode* array2node(vector<int> nums) {
    ListNode ret = ListNode(0);
    ListNode* cur = &ret;
    for (int i = 0; i < nums.size(); ++i) {
        ListNode* tmp = new ListNode(nums[i]);
        cur->next = tmp;
        cur = tmp;
    }

    return ret.next;
}

void print_node(ListNode* head) {
    ListNode* cur = head;

    while (cur) {
        if (cur->next) cout << cur->val << "->";
        else cout << cur->val << endl;
    }
}

void leetcode_test_21(void) {
    vector<int> v1 = { 1, 2, 4};
    vector<int> v2 = { 1, 3, 4};
    ListNode* l1 = array2node(v1);
    ListNode* l2 = array2node(v2);;

    print_node(mergeTwoLists(l1, l2)); // 1->1->2->3->4->4
}