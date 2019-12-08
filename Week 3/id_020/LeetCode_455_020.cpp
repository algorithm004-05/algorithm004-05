// Author: liuwufang
// Date: 2019/10/20

#include <algorithm>
#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/assign-cookies/
// https://leetcode.com/problems/assign-cookies/

// Question:
// 455. 分发饼干
// 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
// 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
// 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。


// Solution:
// 思路1: 贪心法
// 贪心原则是用尽可能小的饼干去满足胃口最小的小孩
// 1.小饼干能满足的孩子，不需要使用大饼干满足
// 2.胃口最小的小孩子用最大的饼干都满足不了，后面的孩子都没有办法满足
// 3.每个孩子的胃口满足后的权值是一样的

// 时间复杂度：O(Nlog(N))))
// 空间复杂度：O(1)

int findContentChildren(vector<int>& g, vector<int>& s) {
    sort(g.begin(), g.end());
    sort(s.begin(), s.end());
    
    int i = 0, j = 0;
    while (i < g.size() && j < s.size()) {
        if (g[i] <= s[j]) i++;
        
        j++;
    }
    
    return i;
}

void leetcode_test_455(void) {
    vector<int>& g = {1, 2, 3};
    vector<int>& s = {1, 1};

    findContentChildren(g, s); // 1
}