package partical

import "fmt"

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:使用递归
	要生成有效的括号对、在添加括号时必须满足右括号数量小于左括号数量

*/
func generateParenthesis(n int) []string {
	//left, right := 0, 0
	_generate0(0, n, "")
	return nil
}

func _generate(left, right int, n int, s string) []string {
	slice := make([]string, 0)
	fmt.Println(" left:", left, " right:", right, " s:", s)
	// 终止条件
	if left == n && right == n {
		slice = append(slice, s)
		fmt.Println(slice)
		return slice
	}
	if left < n {
		slice = append(slice, _generate(left +1, right, n, s +"(")...)
	}
	if right < left {
		slice = append(slice, _generate(left, right + 1, n, s +")")...)
	}
	return slice
}
//leetcode submit region end(Prohibit modification and deletion)

func _generate0(level, n int, s string)  {
	if level >= 2 * n {
		fmt.Println(s)
		return
	}
	_generate0(level + 1, n, s + "(")
	_generate0(level + 1, n, s + ")")

}

func main() {
	generateParenthesis(1)
}