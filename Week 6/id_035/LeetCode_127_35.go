package main

import (
	"fmt"
	"strings"
)

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:BFS+队列
	核心思想:
		1. 将beginWord入队
		2. 为wordList中每个单词生成一个通用单词映射
		3. 遍历队列、出队
		4. 为出队的每个单词生成通用单词、在单词映射中查找、看看是否能找到相同的映射、
		5. 如果能找到、查看映射中的单词是否是endword、如果是、完成、如果不是、将映射中的所有单词入队
*/
type QueueNode struct {
	Word   string
	Length int
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if beginWord == endWord {
		return 0
	}
	queues := make([]*QueueNode, 0)
	queues = append(queues, &QueueNode{
		Word:   beginWord,
		Length: 1,
	})
	// 已经
	is_visited := make(map[string]bool)
	map_set := _generate(wordList)
	is_visited[beginWord] = true
	// 出队
	for len(queues) != 0 {
		var cur_node *QueueNode = new(QueueNode)
		queues, cur_node = _dqueue(queues)
		word := cur_node.Word
		words := strings.Split(word, "")
		for i := 0; i < len(words); i++ {
			data := word[:i] + "*" + word[i+1:len(word)]
			for _, each_word := range map_set[data] {
				if each_word == endWord {
					// 注意:这里必须要+1
					// 比如官方实例中、hit->hot->dot->dog->cog
					// hit时的length是1、后面递增、但在dog出队时
					// 通过*og可以得到该映射下的cog
					// 此时cog==endNode,可以直接返回、不需要入队
					// 也就是说、此时的出队节点cur_node还是cog,所以需要用cog处的length+1
					return cur_node.Length + 1
				}
				if !is_visited[each_word] {
					// 去重、已经判断过的单词不能再入队
					// 比如:hit->h*t->hot, hot入队
					// hot->*ot->[hot,dot],此时hot刚刚出队、不能再入队
					is_visited[each_word] = true
					queues = append(queues, &QueueNode{Word: each_word, Length: cur_node.Length + 1})
				}

			}
		}
	}
	return 0
}

// 出队
func _dqueue(queues []*QueueNode) ([]*QueueNode, *QueueNode) {
	if len(queues) == 0 {
		return nil, nil
	}
	if len(queues) == 1 {
		return nil, queues[0]
	}
	return queues[1:], queues[0]
}

// 为WordList生成通用映射
// hot:h*t, *ot, ho*
func _generate(word_list []string) map[string][]string {
	result := make(map[string][]string)
	for _, word := range word_list {
		words := strings.Split(word, "")
		for i := 0; i < len(words); i++ {
			data := word[:i] + "*" + word[i+1:len(word)]
			result[data] = append(result[data], word)
		}
	}
	return result
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	words := []string{"hot", "dot", "dog", "lot", "log"}
	fmt.Println(ladderLength("hit", "cog", words))
}
