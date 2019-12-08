# NOTE

学习任务：
本周主要是学习哈希表，树，递归和分治的相关知识。
是要是还是关注哈希表和树的部分作业的完成。

深入分析和 Java8 HashMap 的分析，分析如下：

HashMap 是一种 Map，HashMap 仅是一种 Map 的实现版本，Java 中存在多种 Hash 的版本：如 LinkedHashMap, ConcurrentHashMap 等

HashMap 在实现上使用了数组+链表+红黑树三种数据结构，HashMap 是通过计算 key 的 hashCode 来找到记录的存储位置的，那因为 hash 函数不会完美的原因，势必要造成多个记录的 key 的 hashCode 一样的情况（Hash 冲突）。解决哈希冲突的方法主要有开发地址和链地址，HashMap 采用了后者，将 hashCode 相同的记录放在同一个数组位置上，多个 hashCode 相同的记录被存储在一条链表上，我们知道，链表上的查询复杂的为 O(N)，当这个 N 很大的时候也就成了瓶颈，所以 HashMap 在链表的长度大于 8 的时候就会将链表转换为红黑树这种数据结构，红黑树的查询效率高达 O(lgN)，也就是说，复杂度降了一个数量级，完全可以适用于实际生产环境。HashMap 的哈希桶 table 的大小必须为 2 的 n 次方，初始大小为 16。

static class Node<K,V> implements Map.Entry<K,V> {
final int hash; //哈希值，HashMap 用这个值来确定记录的位置
final K key; //记录 key
V value; //记录 value
Node<K,V> next;//链表下一个节点

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
