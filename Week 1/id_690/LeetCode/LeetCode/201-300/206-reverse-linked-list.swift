//
//  206-reverse-linked-list.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa

/*:
 
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
 
输出: 5->4->3->2->1->NULL
 
进阶:
 
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

[206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list)
 
 */

class ReverseLinkedList: NSObject {
    
    func reverseList(_ head: ListNode?) -> ListNode? {
        // 前一个指针
        var prev: ListNode?
        var current = head
        
        while current != nil {
            let next = current?.next
            current?.next = prev
            prev = current
            current = next
        }
        
        return prev
    }
    
}
