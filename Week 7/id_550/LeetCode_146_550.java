class LRUCache {
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            
            // move node to first;
            moveToFirst(node);
            
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            
            moveToFirst(node);
        } else {
            if(map.size() >= capacity){
                map.remove(tail.pre.key);
                delete(tail.pre);
            }
            
            Node cur = new Node(key, value);
            cur.val = value;
            map.put(key, cur);
            
            addToFirst(cur);
        }
    }
    
    private void moveToFirst(Node node){
        delete(node);
        addToFirst(node);
    }
    
    private void delete(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    
    private void addToFirst(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    class Node{
        Node pre = null;
        Node next = null;
        int key;
        int val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
