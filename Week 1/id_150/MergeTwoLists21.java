package com.geek.lee.leetcode.easy;
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

import com.geek.lee.leetcode.linkedlist.ListNode;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * 1. 看到问题后的第一想法.也应该算暴力法
         *  定义一个新的链表,用于返回.
         *  遍历链表, 每次比较两个链表头, 将小的链表头放入新的链表中
         *  逐一比较,直至两个链表为空
         *  该方式由于要遍历两个列表,所以复杂度为O(m+n)
         *  空间复杂度为O(1), 定义了两个常量空间
         */
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

//        // 定义一个新的链表, 用于返回结果.返回的是prehead的next
//        ListNode prehead = new ListNode(-1);
//
//        // 再定义一个链表指向prehead, 该链表用于真实链接其他node
//        ListNode prev = prehead;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            // 记得要移动prev的链表指针, 不然会只剩下一个node.
//            prev = prev.next;
//        }
//        // 到这里 一定是有一个链表空了.
//        prev.next = l1 == null ? l2 : l1;
//        return prehead.next;

        /**
         * 2. 看到官方题解之后得到的答案 递归
         *  每次递归判断l1和l2的哪个更小, 将小的链表的next指向下一次递归的最小结果
         *  该方法有一点不好的地方就是要改变原始参数, 需要断开原始链表的链,重新链到二者其一
         *  相当于给两个链表组合成一个.
         *  该方法也是O(m+n). 需要递归两个链表的所有元素
         */
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

}
