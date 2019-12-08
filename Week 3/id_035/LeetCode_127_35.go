package day31

import "strings"

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
	思路1:广度优先搜索
*/
type Queue struct {
	Word string
	Level int
}
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// 将wordList中所有单词存入map中
	map_dict := make(map[string]bool)
	for _, word := range wordList {
		map_dict[word] = true
	}
	// 判断endWord在map中是否存在以及begin与end是否相等
	if !map_dict[endWord] || beginWord == endWord {
		return 0
	}
	// 获取wordList所有单词的通用状态
	map_status := _getStatus(wordList)
	visited := make(map[string]bool)
	visited[beginWord] = true
	queue := make([]*Queue, 0)
	// 初始化队列
	queue = append(queue, &Queue{Word: beginWord, Level: 1})
	// 如果队列不为空、出队、找到出队的元素所有通用状态映射的单词、与endWord进行判断、如果相等、直接返回
	// 如果不相等、将所有映射到的单词添加到队列中、重复上面的步骤
	for len(queue) != 0 {
		node := &Queue{}
		queue, node = _dqueue(queue)
		slice := strings.Split(node.Word, "")
		for i := 0; i < len(slice); i++ {
			key := strings.Join(slice[0:i], "") + "*" + strings.Join(slice[i+1:len(slice)],"")
			// 获取当前单词的映射单词列表
			for _, word := range map_status[key] {
				if word == endWord {
					return node.Level + 1
				}
				if !visited[word] {
					visited[word] = true
					// 不相等、入队
					queue = append(queue, &Queue{word, node.Level + 1})
				}
			}
		}
	}
	return 0
}

func _dqueue(queues []*Queue) ([]*Queue, *Queue) {
	if len(queues) == 1 {
		return nil, queues[0]
	}
	return queues[1:], queues[0]
}
// 获取wordList所有单词的通用状态(bug->*ug, b*g, bu*)
func _getStatus(word_list []string) map[string][]string {
	map_status := make(map[string][]string)
	for _, word := range word_list {
		slice := strings.Split(word, "")
		for i := 0; i < len(slice); i++ {
			key := strings.Join(slice[0:i], "") + "*" + strings.Join(slice[i+1:len(slice)],"")
			map_status[key] = append(map_status[key], word)
		}
	}
	return map_status
}


//leetcode submit region end(Prohibit modification and deletion)
//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路2:双向广度优先搜索
	前面的单向BFS、如果单词量非常多、会导致节点使用内存非常大
	所以这里可以考虑使用双向BFS、同时从begin和end进行遍历、基本处理逻辑不变
	当begin和end访问到同一个单词时、即说明找到了满足条件的单词、其访问次数应该是
	begin+end,如果其中某一端遍历完整个数组、仍然没有相遇、则说明没有满足条件的单词
	和单向相比、我们可以用两个队列(head,tail)来实现

*/
// todo 执行结果不对
func ladderLength2(beginWord string, endWord string, wordList []string) int {
	// 将wordList中所有单词存入map中
	map_dict := make(map[string]bool)
	for _, word := range wordList {
		map_dict[word] = true
	}
	// 判断endWord在map中是否存在以及begin与end是否相等
	if !map_dict[endWord] || beginWord == endWord {
		return 0
	}
	// 获取wordList所有单词的通用状态
	map_status := _getStatus(wordList)
	head_visited := make(map[string]int)
	head_visited[beginWord] = 1
	tail_visited := make(map[string]int)
	tail_visited[endWord] = 1
	head_queue := make([]*Queue, 0)
	// 初始化队列
	head_queue = append(head_queue, &Queue{Word: beginWord, Level: 1})
	tail_queue := make([]*Queue, 0)
	tail_queue = append(tail_queue, &Queue{Word: endWord, Level: 1})
	var count = new(int)
	// 如果队列不为空、出队、找到出队的元素所有通用状态映射的单词、与endWord进行判断、如果相等、直接返回
	// 如果不相等、将所有映射到的单词添加到队列中、重复上面的步骤
	for len(head_queue) != 0 && len(tail_queue) != 0{
		count = _visitWordNode(map_status, &head_queue, head_visited, tail_visited)
		if nil != count {
			return *count
		}
		count = _visitWordNode(map_status, &tail_queue, tail_visited, head_visited)
		if nil != count {
			return *count
		}
	}
	return 0
}

func _visitWordNode(map_status map[string][]string,queues *[]*Queue, self map[string]int, other map[string]int) *int {
	// 出队
	curr_node := &Queue{}
	*queues, curr_node = _dqueue(*queues)
	// 找到通用状态及映射单词
	slice := strings.Split(curr_node.Word, "")
	for i := 0; i < len(slice); i++ {
		key := strings.Join(slice[0:i], "") + "*" + strings.Join(slice[i+1:len(slice)],"")
		// node所有映射单词
		for _, word := range map_status[key] {
			// 判断映射单词是否也被另一个队列访问
			if _, ok := other[word]; ok {
				level := other[word] + curr_node.Level
				return &level
			}
			if _, ok := self[word]; !ok {
				self[word]++
				*queues = append(*queues, &Queue{word, curr_node.Level + 1})
			}
		}
	}
	return nil
}