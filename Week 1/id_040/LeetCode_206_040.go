package main

import "fmt"

// 第二遍 2019年10月16日
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {

	var prev *ListNode
	for head != nil {
		head.Next, prev, head = prev, head, head.Next
	}

	return prev

}

//leetcode submit region end(Prohibit modification and deletion)

func main() {
	n1 := ListNode{Val: 1, Next: nil}
	n2 := ListNode{Val: 2, Next: nil}
	n3 := ListNode{Val: 3, Next: nil}
	n4 := ListNode{Val: 4, Next: nil}
	n5 := ListNode{Val: 5, Next: nil}

	n1.Next = &n2
	n2.Next = &n3
	n3.Next = &n4
	n4.Next = &n5
	n5.Next = nil

	n := reverseList(&n1)

	for n != nil {
		fmt.Println(n.Val)
		n = n.Next
	}

}
