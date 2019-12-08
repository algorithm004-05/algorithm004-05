/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return nil
    }

    slow, fast := head.Next, head.Next.Next
    for fast != nil && fast.Next != nil && slow != fast {
        slow, fast = slow.Next, fast.Next.Next
    }

    if slow != fast {
        return nil
    }

    for slow != head {
        slow, head = slow.Next, head.Next
    }
    return slow
}

func detectCycleOne(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return nil
    }
    // 设置快慢指针
    slow, fast := head, head
    for fast.Next != nil && fast.Next.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        // 第一轮相遇证明有环
        if slow == fast {
              tmp := head
              // 第二轮相遇确定环的入口
              for tmp != slow {
                slow = slow.Next
                tmp = tmp.Next
              }
              return tmp
        }
    }
    return nil
}
