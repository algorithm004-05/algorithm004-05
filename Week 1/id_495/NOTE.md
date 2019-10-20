# NOTE

## 作业一: 用add first或add last这套新的API改写Deque的代码

```java
public class OldDemo {

  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<String>();

    deque.push("a");
    deque.push("b");
    deque.push("c");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会抛出NoSuchElementException异常
      System.out.println(deque.pop());
    }
    System.out.println(deque);
  }
}
```

```java
public class NewLinkedListDemo {

  public static void main(String[] args) {
    // LinkedList没有指定并固定容量的构造方法
    Deque<String> deque = new LinkedList<String>();

    // 如果可以立即执行此操作，而不会违反容量限制，则在此双端队列的前面插入指定的元素；
    // 如果当前没有可用空间，则抛出IllegalStateException
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    deque.addLast("d");
    // 这里插入成功会返回true
    boolean result = deque.offerFirst("e");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会返回null
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);
  }
}
```

```java
public class NewLinkedBlockingDequeDemo {

  public static void main(String[] args) {

    // 这里指定容器的固定容量为3
    Deque<String> deque = new LinkedBlockingDeque<String>(3);

    // 如果可以立即执行此操作，而不会违反容量限制，则在此双端队列的前面插入指定的元素；
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    // 这里的插入由于容器没有可用空间，则抛出IllegalStateException
    // deque.addLast("d");

    // 这里的插入成功会返回true,失败会返回false,不会抛出异常
    boolean result = deque.offerFirst("e");
    System.out.println(deque);

    String str = deque.peek();
    System.out.println(str);
    System.out.println(deque);

    while(deque.size() > 0) {
      // 这里如果LinkedList为空，会返回null
      System.out.println(deque.pollFirst());
    }
    // pop方法,由于容器中没有元素，会抛出异常NoSuchElementException
    // deque.pop();
    /*
    TODO: deque.pollFirst(long timeout, TimeUnit unit) 这个方法是怎么用的?
    */
    System.out.println(deque);
  }
}
```

## 作业二: 分析Queue和Priority Queue的源码

### 分析Queue源码
