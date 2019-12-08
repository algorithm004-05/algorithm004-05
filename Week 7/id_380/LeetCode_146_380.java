//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计



//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    DoubleListNode list;
    Map<Integer,DoubleListNode> map ;
    int size;
    static DoubleListNode head;
    static DoubleListNode tail;
    public LRUCache(int capacity) {
        size =capacity;
        map = new HashMap<Integer,DoubleListNode>();
        head = new DoubleListNode(-1,-1);
        tail = new DoubleListNode(-1,-1);
        head.next =tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(size==0){
            return -1;
        }
        if(map.containsKey(key)){
            DoubleListNode node = map.get(key);
            delete(node);
            add(node);
            return map.get(key).val;
        }
        return -1;

    }

    public void put(int key, int value) {
        if(size ==0)
            return;
        if(!map.containsKey(key)) {
            if(map.size()>=size){
                DoubleListNode OldTail = tail.prev;
                delete(OldTail);
                map.remove(OldTail.key);
            }
            DoubleListNode node = new DoubleListNode(key,value);
            add(node);
            map.put(key,node);

        }else{
            DoubleListNode node_0 = map.get(key);
            delete(node_0);
            map.remove(node_0.key);
            DoubleListNode node2 = new DoubleListNode(key,value);
            add(node2);

            map.put(key,node2);
        }
    }

    private static void delete(DoubleListNode node){
        DoubleListNode prev = node.prev;
        DoubleListNode next = node.next;
        prev.next = next;
        next.prev =prev;

    }

    private static void add(DoubleListNode node){
        DoubleListNode OldFirst = head.next;
        head.next = node;
        node.prev = head;
        node.next = OldFirst;
        OldFirst.prev = node;
    }

}
class DoubleListNode{
    DoubleListNode prev;
    DoubleListNode next;
    int val;
    int key;
    public DoubleListNode(int key,int val){
        this.key = key;
        this.val = val;

    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
