package main

import "fmt"

//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
// 示例:
//
// 输入:

//
//输出: ["eat","oath"]
//
// 说明:
//你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示:
//
//
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
// 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
// Related Topics 字典树 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:dfs + trie-->通过字典树进行处理
	将所有的words存入字典树中、然后遍历board、组装遍历的每一个字母成为单词、去trie中查找
	检查其是否是trie中某个单词的前序或者是单词本身、如果是、则采用dfs继续向其周围4个方向进行查找、
	如果不存在、直接返回nil
*/
type Trie struct {
	IsEnd bool
	Nodes []*Trie
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{
		false,
		make([]*Trie, 26),
	}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	next := this.Nodes
	for i := 0; i < len(word); i++ {
		// 检查是否已包含
		if next[word[i]-'a'] == nil {
			next[word[i]-'a'] = new(Trie)
			next[word[i]-'a'].Nodes = make([]*Trie, 26) // 初始化下一轮
		}
		if i == len(word)-1 {
			next[word[i]-'a'].IsEnd = true
		}
		next = next[word[i]-'a'].Nodes
	}
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	next := this.Nodes
	for i := 0; i < len(word); i++ {
		// 检查是否已包含
		if next[word[i]-'a'] == nil {
			return false
		}
		if i == len(word)-1 && next[word[i]-'a'].IsEnd {
			// 最后一个字母也是结束符
			return true
		}
		next = next[word[i]-'a'].Nodes
	}
	return false
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	next := this.Nodes
	for i := 0; i < len(prefix); i++ {
		// 检查是否已包含
		if next[prefix[i]-'a'] == nil {
			return false
		}
		next = next[prefix[i]-'a'].Nodes
	}
	return true
}

var dx = []int{-1, 0, 1, 0}
var dy = []int{0, 1, 0, -1}

func findWords(board [][]byte, words []string) []string {
	trie := Constructor()
	for _, word := range words {
		trie.Insert(word)
	}
	cur_word := ""
	mem := make([][]int, len(board))
	for i := 0; i < len(board); i++ {
		mem[i] = make([]int, len(board[i]))
	}
	map_result := make(map[string]bool)
	result := make([]string, 0)
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			_trie_search(i, j, board, cur_word, mem, &result, &trie, map_result)
			cur_word = ""
		}
	}
	return result
}

// dfs递归
func _trie_search(i int, j int, board [][]byte, cur_word string, memory [][]int, result *[]string, trie *Trie, map_result map[string]bool) {
	// terminal
	if i < 0 || i > len(board)-1 || j < 0 || j > len(board[i])-1 {
		return
	}
	if memory[i][j] == 1 {
		return
	}
	cur_word += string(board[i][j])

	if trie.Search(cur_word) {
		if !map_result[cur_word] {
			*result = append(*result, cur_word)
		}
		map_result[cur_word] = true
		// todo 一定注意、这里不能直接return、因为有可能同时要查找aaa, aaab,如果返回了、会导致找不到aaab
	}
	// current logic
	if trie.StartsWith(cur_word) {
		memory[i][j] = 1
		for k := 0; k < len(dx); k++ {
			next_row := i + dy[k]
			next_col := j + dx[k]
			// drill down
			_trie_search(next_row, next_col, board, cur_word, memory, result, trie, map_result)
		}
		memory[i][j] = 0
	}
	return
}

//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//leetcode submit region end(Prohibit modification and deletion)

func main() {
	//var dx = []int{-1, 0, 1, 0}
	//var dy = []int{0, 1, 0, -1}
	board := [][]byte{
		{'a', 'b'},
		{'a', 'a'}}
	words := []string{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"}
	obj := Constructor()
	for _, word := range words {
		obj.Insert(word)
	}
	fmt.Println(findWords(board, words))
}
