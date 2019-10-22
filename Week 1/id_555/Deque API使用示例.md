Deque API文档地址：
[https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Deque.html](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Deque.html)


# Deque API使用示例

# push和pop
```java
public void doDeque() {
		Deque<String> deque = new LinkedList<String>();
		deque.push("a");
		deque.push("b");
		deque.push("c");
		System.out.println(deque);

		String str = deque.peek();
		System.out.println(str);
		System.out.println(deque);

		while (deque.size() > 0) {
			System.out.println(deque.pop());
		}

		System.out.println(deque);
	}
```


输出结果为：
>[c, b, a]
>c
>[c, b, a]
>c
>b
>a
>[]

---

# addFirst


```java
public void doDeque() {
		Deque<String> deque = new LinkedList<String>();
		deque.addFirst("a");
		deque.addFirst("b");
		deque.addFirst("c");
		
		System.out.println(deque);

		String str = deque.peek();
		System.out.println(str);
		System.out.println(deque);
		
		System.out.println(deque.removeFirst());
		System.out.println(deque);
		
	}
```
打印结果：
>[c, b, a]
>c
>[c, b, a]
>c
>[b, a]

---

# addLast

```java
	public void doDeque() {
		Deque<String> deque = new LinkedList<String>();
		deque.addLast("c");
		deque.addLast("b");
		deque.addLast("a");

		System.out.println(deque);

		String str = deque.peek();
		System.out.println(str);
		System.out.println(deque);

		System.out.println("移除第一个元素为 " + deque.removeFirst());
		System.out.println("移除第一个元素后: " + deque);
		System.out.println("移除最后一个元素为 " + deque.removeLast());
		System.out.println("移除最后一个元素后: " + deque);

	}
```
打印结果：
>[c, b, a]
>c
>[c, b, a]
>移除第一个元素为 c
>移除第一个元素后: [b, a]
>移除最后一个元素为 a
>移除最后一个元素后: [b]