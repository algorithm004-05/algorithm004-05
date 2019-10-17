#设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
#
#
# push(x) -- 将元素 x 推入栈中。
# pop() -- 删除栈顶的元素。
# top() -- 获取栈顶元素。
# getMin() -- 检索栈中的最小元素。
#
#
# 示例:
#
# MinStack minStack = new MinStack();
#minStack.push(-2);
#minStack.push(0);
#minStack.push(-3);
#minStack.getMin();   --> 返回 -3.
#minStack.pop();
#minStack.top();      --> 返回 0.
#minStack.getMin();   --> 返回 -2.
#
# Related Topics 栈 设计



#leetcode submit region begin(Prohibit modification and deletion)
class MinStack:
    """ 用int记录最小值 """

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_value = 0


    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.stack) == 1:
            self.min_value = x
        else:
            self.min_value = min(self.min_value, x)

    def pop(self) -> None:
        v = self.stack.pop()
        if v == self.min_value:
            if len(self.stack) != 0:
                self.min_value = min(self.stack)

    def top(self) -> int:
        if len(self.stack) != 0:
            return self.stack[-1]
        else:
            return None


    def getMin(self) -> int:
        if len(self.stack) == 0:
            return None
        else:
            return self.min_value

class MinStack2:
    """ 用辅助栈记录最小值 """

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []


    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack) == 0:
            self.min_stack.append(x)
        else:
            if x <= self.min_stack[-1]:
                self.min_stack.append(x)

    def pop(self) -> None:
        if len(self.stack) != 0:
            v = self.stack.pop()
            if v == self.min_stack[-1]:
                self.min_stack.pop()

    def top(self) -> int:
        if len(self.stack) != 0:
            return self.stack[-1]

    def getMin(self) -> int:
        if len(self.min_stack) != 0:
            return self.min_stack[-1]



# Your MinStack object will be instantiated and called as such:
if __name__ == '__main__':
    minStack = MinStack2()
    minStack.push(6)
    minStack.push(6)
    minStack.push(7)
    minStack.top()
    minStack.pop()
    minStack.getMin()
    minStack.pop()
    minStack.getMin()
    minStack.pop()
    minStack.push(7)
    minStack.top()
    minStack.getMin()
    minStack.push(-8)
    minStack.top()
    minStack.getMin()
    minStack.pop()
    minStack.getMin()
    print(minStack.getMin())
    print(minStack.pop())
    print(minStack.top())
    print(minStack.getMin())

#leetcode submit region end(Prohibit modification and deletion)
