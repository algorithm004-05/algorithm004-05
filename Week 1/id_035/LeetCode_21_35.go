package id_035

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val int
	Next *ListNode
}

/*
	思路1:双指针法
	给定两个链表的指针p1, p2分别标记l1, l2
	对p1,p2所指的节点进行比较将小的插入到新的链表中
	如果两边都比较完成之后、还有多余的元素没有插入、说明未插入元素比前面的都大、直接追加到后面
*/

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	p1 := l1
	p2 := l2
	p := &ListNode{}
	head := p
	for p1 != nil && p2 != nil {
		if p1.Val <= p2.Val {
			p.Next = p1
			p1 = p1.Next
		} else {
			p.Next = p2
			p2 = p2.Next
		}
		p = p.Next
	}

	if p1 != nil {
		p.Next = p1
	}

	if p2 != nil {
		p.Next = p2
	}
	return head.Next
}

/*
	思路2:递归
	返回值:排好序的链表头
	终止条件:l1为空或者l2为空
	调用单元实现功能:l1与l2进行比较、如果l1.val<l2.val、则l1作为当前子链表表头、再将l1.next.val再与l2.val进行比较
*/
func mergeTwoLists2(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next =  mergeTwoLists(l1.Next, l2)
		return l1
	} else {
		l2.Next =  mergeTwoLists(l1, l2.Next)
		return l2
	}
}

/*
	思路3:直接遍历
	给定一个空节点作为虚拟头节点
	在遍历的同时比较l1和l2大小、只要有一个为空、跳出循环
*/
func mergeTwoLists3(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	node := dummy
	for ;l1 != nil || l2 != nil; node = node.Next {
		if l1 == nil {
			node.Next = l2
			break
		}
		if l2 == nil {
			node.Next = l1
			break
		}
		if l1.Val >= l2.Val {
			node.Next = l2
			l2 = l2.Next
		} else {
			node.Next = l1
			l1 = l1.Next
		}
	}
	return dummy
}