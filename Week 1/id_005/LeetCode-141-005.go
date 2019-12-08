/**
 * 使用快慢指针
 * 执行用时 :8 ms, 在所有 golang 提交中击败了90.53%的用户
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	// 设置快慢指针
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if slow == fast {
			return true
		}
	}
	return false
}

func hasCycleOne(head *ListNode) bool {
    if head == nil || head.Next == nil {
        return false
    }
    fast, slow := head.Next, head
    for fast != slow {
        if fast == nil || fast.Next == nil {
            return false
        }
        fast = fast.Next.Next
        slow = slow.Next
    }

    return true
}

/**
 * 迭代
 * 执行用时 :8 ms, 在所有 golang 提交中击败了90.05%的用户
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycleTwo(head *ListNode) bool {
    for head != nil {
        if head == head.Next {
            return true
        }
        if head.Next != nil {
            head.Next = head.Next.Next
        }
        head = head.Next
    }
    return false
}
