package example;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] strs) throws Exception {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("add value to first place with exception for capacity over");
        deque.addLast("add value to last place with exception for capacity over");
        deque.offerFirst("add value to first palce with specia value for capacity over");
        deque.offerLast("add value to last place wiht specia value for capacity over");
        System.out.println("after add:" + deque);

        System.out.println("getvalue:" + deque.getFirst());
        System.out.println("peekvalue:" + deque.peekFirst());
        System.out.println("getvalue2:" + deque.getLast());
        System.out.println("peekvalue2:" + deque.peekLast());

        System.out.println("before remove:" + deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
            System.out.println(deque.pollFirst());
            System.out.println(deque.removeLast());
            System.out.println(deque.pollLast());
        }
        System.out.println("after remove:" + deque);
        System.out.println("空队列移除抛出异常：" + deque.removeFirst());
        System.out.println("空队列移除返回特殊值：" + deque.pollFirst());
    }
}

