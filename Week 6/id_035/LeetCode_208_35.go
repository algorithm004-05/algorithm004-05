package main

import "fmt"

//
//import "fmt"
//
////实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
////
//// 示例:
////
//// Trie trie = new Trie();
////
////trie.insert("apple");
////trie.search("apple");   // 返回 true
////trie.search("app");     // 返回 false
////trie.startsWith("app"); // 返回 true
////trie.insert("app");
////trie.search("app");     // 返回 true
////
//// 说明:
////
////
//// 你可以假设所有的输入都是由小写字母 a-z 构成的。
//// 保证所有输入均为非空字符串。
////
//// Related Topics 设计 字典树
//
//
///*
//	思路1:
//	分析:根据题义、所有输入都是由小写字母构成、所以根节点下面可以有26个子节点、同理
//	每个子节点也可以有26个子节点、应该有26层
//	可以用一个大小为26的数组或者切片进行构造或者map进行构造
//	因为这里是英文字母、所以我们使用map
//*/
//leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
	Val   string
	Tries map[string]*Trie
	IsEnd bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		"",
		make(map[string]*Trie),
		false,
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	next := this.Tries
	for _, w := range word {

		s := string(w)
		// 先检查是否包含
		if _, ok := next[s]; !ok {
			next[s] = new(Trie)
			next[s].Tries = make(map[string]*Trie)
		}
		next = next[s].Tries
	}
	// 结尾标记
	next[""] = new(Trie)
	next[""].IsEnd = true
	fmt.Println(next[""])

}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	next := this.Tries
	for _, w := range word {
		s := string(w)
		// 先检查是否包含
		if _, ok := next[s]; !ok {
			return false
		}
		next = next[s].Tries
	}
	if _, ok := next[""]; ok && next[""].IsEnd {
		return true
	}
	return false
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	next := this.Tries
	for _, w := range prefix {
		if nil == next {
			// 已经找到叶子节点、但没有找到相同的单词
			return false
		}
		s := string(w)
		// 先检查是否包含
		if _, ok := next[s]; !ok {
			return false
		}
		next = next[s].Tries
	}

	return true
}

/**
* Your Trie object will be instantiated and called as such:
* obj := Constructor();
* obj.Insert(word);
* param_2 := obj.Search(word);
* param_3 := obj.StartsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
func main() {
	obj := Constructor()
	obj.Insert("apple")

	obj.Insert("app")
	//obj.Insert("beer")
	//obj.Insert("add")
	//obj.Insert("jam")
	//obj.Insert("rental")

	//fmt.Println(obj.Search("ap"))
	//fmt.Println(obj.Search("app"))

	//fmt.Println(obj.Search("apps"))

}
