/*
 * @lc app=leetcode.cn id=20 lang=c
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (39.74%)
 * Likes:    1137
 * Dislikes: 0
 * Total Accepted:    142.1K
 * Total Submissions: 356.4K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start


bool isValid(char * s){
    //第一个问题，没有字符串长度，如何遍历？
    // A：对于字符串，总是以‘\0’结尾;或者使用strlen() 函数计算长度,sizeof（）为单目运算符；
    if(s == NULL || s[0] == '\0') return true;
    char *stack = (char *)malloc(strlen(s)+1);
    int top = 0;
    for (int i=0;s[i];++i){// 判断是s[i]是否能正确判断字符串结束？
        if (s[i]=='(' || s[i] =='{' || s[i] =='[') stack[top++] = s[i];
        else{
            //此时top指向栈顶，栈顶为准备读入元素地方，未存在元素
            if ((--top)<0) return false;//栈为空
            if(s[i] == ')' && stack[top] !='(') return false;
            if(s[i] == '}' && stack[top] !='{') return false;
            if(s[i] == ']' && stack[top] !='[') return false;
        }
    }
    return (!top);
}


// @lc code=end

