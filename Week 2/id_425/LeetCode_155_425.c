/*
 * @lc app=leetcode.cn id=155 lang=c
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (50.26%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    50.1K
 * Total Submissions: 99.6K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

// @lc code=start
// szh 2019-10-23


#define MAXSIZE 1600
typedef struct {
    int *data;
    int top;
} MinStack;

/** initialize your data structure here. */

MinStack* minStackCreate() {
    MinStack *s = (MinStack*)malloc( sizeof(MinStack));
    s->data = (int *)malloc(MAXSIZE * sizeof(int));
    s->top =-1;
    return s;
}

void minStackPush(MinStack* obj, int x) {
  if (obj -> top == MAXSIZE -1);
  else {
      if (obj ->top == -1){
          obj-> top++;
          obj->data[obj->top++] = x;
          obj->data[obj->top] = x;
      }
      else{
          //栈顶元素为当前栈中最小值，第二元素才为正常入栈的栈顶元素，即每加入一个元素即需占用两个位置。
          int temp = obj->data[obj->top++];
          obj->data[obj->top++] = x;
          obj->data[obj->top] = x<temp? x:temp;
      }
  }
}

void minStackPop(MinStack* obj) {
  if(obj->top == -1);
  else obj->top -= 2;
}

int minStackTop(MinStack* obj) {
  if(obj->top == -1) return;
  return obj->data[(obj->top)-1];
}

int minStackGetMin(MinStack* obj) {
  if(obj->top == -1) return;
  return obj->data[obj->top];
}

void minStackFree(MinStack* obj) {
    free(obj->data);
    obj->data = NULL;
    free(obj);
    obj = NULL;;
    
}

/**
 * Your MinStack struct will be instantiated and called as such:
 * MinStack* obj = minStackCreate();
 * minStackPush(obj, x);
 
 * minStackPop(obj);
 
 * int param_3 = minStackTop(obj);
 
 * int param_4 = minStackGetMin(obj);
 
 * minStackFree(obj);
*/

/**
 * Your MinStack struct will be instantiated and called as such:
 * MinStack* obj = minStackCreate();
 * minStackPush(obj, x);
 
 * minStackPop(obj);
 
 * int param_3 = minStackTop(obj);
 
 * int param_4 = minStackGetMin(obj);
 
 * minStackFree(obj);
*/
// @lc code=end

