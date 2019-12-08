<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution
{

    /**
     * 栈 代码量最少
     * 执行用时 :12 ms, 在所有 php 提交中击败了93.18%的用户
     * @param ListNode $head
     * @param Integer $k
     * @return ListNode
     */
    public function reverseKGroupStack($head, $k)
    {
        $swapedNodePointer = $head;// 创建用来反转的指针
        $currentVal = $head;// 创建用来反转的指针
        $stack = new SplStack();
        $currentCounter = 1;
        while (!empty($currentVal) || !empty($currentVal->next)) {
            // 要反转的内容放进栈里面
            $stack->push($currentVal->val);
            if ($currentCounter % $k == 0) {
                while (!empty($stack->count()) && !empty($swapedNodePointer->next)) {
                    $swapedNodePointer->val = $stack->pop(); // 开始反转
                    $swapedNodePointer = $swapedNodePointer->next; // 为下次赋值做准备
                }
            }
            $currentVal = $currentVal->next;
            $currentCounter++;
        }

        return $head;
    }

    /**
     * 看题解最优
     * 执行用时 :8 ms, 在所有 php 提交中击败了100.00%的用户
     * @param ListNode $head
     * @param Integer $k
     * @return ListNode
     */
    public function reverseKGroup($head, $k)
    {
        if ($head == null || $head->next == null) {
            return $head;
        }
        $new_head = new ListNode(0);// 创建一个 0 节点开头的链表
        $new_head->next = $head;// 将该虚拟链表指向主角
        $pre = $new_head;
        $end = $pre;// 要反转的部分
        while ($end->next != null) {
            // 找到要反转的部分的结尾
            for ($i = 0; $i < $k && $end; $i++) {
                $end = $end->next;
            }
            // 结尾为空结束循环
            if (!$end) {
                break;
            }
            $start = $pre->next; // 要反转的部分的开头
            $temp = $end->next;// 要反转的部分的结尾指向的节点
            $end->next = null; // 要反转的部分的结尾指向空
            $pre->next = $this->reverse($start);// 从 0 节点开头的部分指向整个反转好了的链表
            $start->next = $temp;// 接上剩余的部分
            $pre = $start;
            $end = $pre;
        }
        return $new_head->next;
    }

    public function reverse($start)
    {
        $cur = $start;
        $pre = new ListNode(0);
        while ($cur) {
            $temp = $cur->next;
            $cur->next = $pre;
            $pre = $cur;
            $cur = $temp;
        }
        return $pre;
    }
}
