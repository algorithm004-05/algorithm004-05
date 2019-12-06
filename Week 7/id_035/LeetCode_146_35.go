package main

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

/*
	思路
		基本属性
			size:确定容量上限
		时间复杂为要为O(1)
			1. 获取时直接查看里面是否有对应的元素、如果没有则返回-1、如果有则返回val, 并将key移动到头部
			2. 插入时首先判断要插入的key是否已经存在、如果已经存在、直接更新、并将key移动到头部
			3. 如果不存在、先判断大小是否超过、如果超过、删掉尾部的元素、然后插入、如果没有超过、插到头部
		这里可以采用双向链表+hashmap
*/
//leetcode submit region begin(Prohibit modification and deletion)
type LRUCache struct {
	Size    int
	Slice   []*Node       // 用于插入、更新和删除
	HashMap map[int]*Node // 用于查找
}
// 节点信息
type Node struct {
	Key   int // key
	Val   int // val
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		Size: capacity,
		Slice:make([]*Node, 0),
		HashMap: make(map[int]*Node),
	}
}

func (this *LRUCache) Get(key int) int {
	if this.HashMap[key] != nil {
		this.move_to_head(key)
		return this.HashMap[key].Val
	}
	return -1
}

// 将指定元素移动到头部
func (this *LRUCache) move_to_head(key int) {
	for i := 0; i < len(this.Slice); i++ {
		if key == this.Slice[i].Key {
			_to_move := this.Slice[i]
			this.Slice = append(this.Slice[:i], this.Slice[i+1:]...)
			new_slice := make([]*Node,0)
			new_slice = append(new_slice, _to_move)
			this.Slice = append(new_slice, this.Slice...)
		}
	}
}

func (this *LRUCache) Update(key int, val int) {
	for i := 0; i < len(this.Slice); i++ {
		if key == this.Slice[i].Key {
			this.Slice[i].Val = val
		}
	}
}

func (this *LRUCache) Put(key int, value int) {
	if this.HashMap[key] != nil {
		this.HashMap[key].Val = value
		this.Update(key, value)
		this.move_to_head(key)
		return
	}
	if len(this.Slice) == this.Size {
		to_del := this.Slice[len(this.Slice) - 1]
		this.Slice = this.Slice[:len(this.Slice) - 1]
		delete(this.HashMap, to_del.Key)
	}
	this.HashMap[key] = new(Node)
	this.HashMap[key].Val = value
	this.HashMap[key].Key = key
	new_slice := make([]*Node, 0)
	new_slice = append(new_slice, &Node{Key:key, Val:value})
	this.Slice = append(new_slice, this.Slice...)
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
func main() {

}