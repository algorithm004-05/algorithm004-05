学习总结
	经过一周的算法学习，我对算法有了一个初步认识。从最开始的一听到算法就怕，到现在对算法渐渐产生兴趣。现在看来，算法也没有我想象的这么难。
在大学就接触过数据结构，所以在老师讲解数组、链表等熟悉的名词时，也唤起了我对以前知识的记忆。在刚开始做题时，除了做老师讲过的题会有点思路之外，
做其他大部分的题要不就是没有思路，要不就是暴力方法。然后就是看答案，理解之后再重新做。当时感觉会好很多，但是后面我整理作业时发现，又有好多的解法
忘了。只能再看再做，老师的五毒神掌果然时绝世秘籍啊。其实想想很多东西都和上学时一样，一个知识点重复练习来提高对知识点的理解和记忆，从而形成一个条件
反射。只是参加工作后，我自己似乎已经很难静下心来踏实学习了。通过这次算法学习，我更希望的时找回那种感觉，在自己的工作中也能够保持这样的学习节奏。同时，
对于算法要多练，代码要多敲。


/**
 * 双端队列
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 */
public class MyDequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}

Queue 总结
Queue是一个接口，以下是它的接口方法
添加元素
boolean add(E e) 添加元素，成功返回true，如果超过当前容量，则抛出异常
boolean offer(E e) 添加元素成功返回true，否则返回false，当使用容器受限队列时使用
删除元素
E remove() 检索并删除此队列的头，如果队列为空，则抛出异常
E poll()  检索并删除此队列的头，如果此队列为空，则返回null。 
获取元素
E element() 检索但不删除此队列的头，如果超过当前容量，则抛出异常
E peek()  检索但不删除此队列的头，如果此队列为空，则返回null。 


PriorityQueue 总结
Class PriorityQueue<E> 类实现了以下接口
Serializable, Iterable<E>, Collection<E>, Queue<E>
特性
	基于优先级堆的无限优先级队列。优先级队列的元素根据其自然顺序排序，或者由队列构造时提供的比较器排序，具体取决于使用的构造函数。
优先级队列不允许空元素。依赖自然排序的优先级队列也不允许插入不可比较的对象，否则会抛出异常。此队列的头是相对于指定顺序的最小元素。
添加元素
boolean add(E e)  将指定的元素插入此优先级队列。其底层调用的是boolean offer(E e)，没有做任何处理。
boolean offer(E e)  
	当无法比较时会抛出ClassCastException异常
	当e == null时，会抛出NullPointerException异常
	如果容量不够，将队列进行扩容
获取元素
E peek() 检索但不删除此队列的头，如果此队列为空，则返回null
E poll() 检索并删除此队列的头，如果此队列为空，则返回null。
	将最后一个元素e取出，然后将最后一个位置置为空，如果队列容量不为0，再将元素e放入队列
删除元素
boolean remove(Object o) 从队列中删除指定元素的单个实例。如果此队列包含一个或多个这样的元素，则移除第一个搜索到的元素e，否则返回false。
	该方法底层调用的是private int indexOf(Object o)方法
查询元素
	boolean contains(Object o) 如果此队列包含指定元素，则返回true。该方法底层调用的是private int indexOf(Object o)方法
	Iterator<E> iterator() 返回此队列中元素的迭代器。迭代器不按任何特定顺序返回元素。使用内部类实现。
其他方法
	void clear() 移除队列所有元素
	int size() 返回此队列中的元素数
	Comparator<? super E> comparator() 返回用于对此队列中的元素排序的比较器，如果此队列是根据其元素的自然顺序排序的，则返回空值。
	Object[] toArray() 返回包含此队列中所有元素的数组。元素没有特定的顺序。底层实现：Arrays.copyOf(queue, size);
	<T> T[] toArray(T[] a)   与Object[] toArray()类似


