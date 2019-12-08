// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <stack>
using namespace std;

// https://leetcode-cn.com/problems/trapping-rain-water/
// https://leetcode.com/problems/trapping-rain-water/

// Question:
// 42. 接雨水
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// Solution:
// 思路1:栈（思路类似于 NO.84 求解矩形面积）
// 当栈顶当高度大于后续元素当高度入栈，否则依次出栈，并计算水量，进行累加

// 时间复杂度：O(N)
// 空间复杂度：O(N)
int trap(vector<int>& height) {
    int sum = 0;
    int cur = 0;
    stack<int> st;
    int size = height.size();
    while (cur < size) {
        // 1. 当cur墙的高度大于栈顶高度时，出栈
        while (!st.empty() && height[cur] > height[st.top()]) {
            int h = st.top();
            st.pop();
            
            // 1.1 判断栈是否空（左侧是否还有墙），空则返回
            if (st.empty())  break;
            
            // 1.2 计算两堵墙度距离和高度
            int distance = cur - st.top() - 1;
            int min_height = min(height[cur], height[st.top()]);
            
            // 1.3 累加雨水
            sum += distance * (min_height - height[h]);
        }
        
        // 2. 当cur墙的高度小于栈顶高度时，入栈
        st.push(cur++);
    }
    
    return sum;
}

// Solution:
// 思路2:双指针（待补充）

void leetcode_test_42(void) {
    vector<int> nums{0,1,0,2,1,0,1,3,2,1,2,1};

    trap(nums);   // 6
}