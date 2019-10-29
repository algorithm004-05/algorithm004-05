# NOTE

  

### 用 add first 或 add last 这套新的 API 改写 Deque 的代码

```
import java.util.Deque;
import java.util.LinkedList;

public class NewApiForDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        //从低位索引开始添加
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        //取出索引为0的元素
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            //取出索引位最高的元素
            System.out.println(deque.removeLast());
        }
        System.out.println(deque);
    }

}
```