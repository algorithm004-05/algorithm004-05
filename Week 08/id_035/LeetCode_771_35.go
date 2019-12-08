package main

import (
	"fmt"
	"strings"
)

/*
	 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

	J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

	示例 1:

	输入: J = "aA", S = "aAAbbbb"
	输出: 3
	示例 2:

	输入: J = "z", S = "ZZ"
	输出: 0
	注意:

	S 和 J 最多含有50个字母。
	 J 中的字符不重复。
*/
/*
	思路1:将J的每一个字符存入map,遍历s进行对比判断
	时间复杂度:O(n)
	空间复杂度:O(n)
*/
func numJewelsInStones(J string, S string) int {
	set := make(map[byte]bool)
	count := 0
	for _, j := range J {
		set[byte(j)] = true
	}
	for _, s := range S {
		if set[byte(s)] {
			count++
		}
	}
	return count
}

/*
	思路2:调用系统函数
*/
func numJewelsInStones2(J string, S string) int {
	count := 0
	for _, s := range J {
		count += strings.Count(S, string(s))
	}
	return count
}

func main() {
	J := "aA"
	s := "aAAbbbb"
	fmt.Println(numJewelsInStones2(J, s))
}
