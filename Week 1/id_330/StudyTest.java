import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class StudyTest {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedBlockingQueue<>();
        queue.add("a");

        LinkedList<String> deque = new LinkedList<>();
        deque.addFirst("a");


        PriorityQueue<Object> pq = new PriorityQueue<>();
        pq.add("q");
        pq.add("a");
        pq.add("b");
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> strMap = new HashMap<>();
        strMap.put(')', '(');
        strMap.put(']', '[');
        strMap.put('}', '{');

        if (s.length() % 2 == 1 || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (strMap.containsKey(c)) {
                char element = stack.empty() ? '#' : stack.pop();
                if (element != strMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }


}
