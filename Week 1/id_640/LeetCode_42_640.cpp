class Solution {
​    public:
​    int trap(vector<int>& *height*)
​    {
​        int        sum      = 0;
​        int        i        = 0;
​        int        distance = 0;
​        stack<int> rain;
​        while (i < height.size()) {
​            while (!rain.empty() && (height[i] > height[rain.top()])) {
​                int j = rain.top();
​                rain.pop();
​                if (rain.empty()) {
​                    break;
​                }
​                distance             = i - rain.top() - 1;
​                int height_rectangle = min(height[i], height[rain.top()]) - height[j];
​                sum                  = sum + distance * height_rectangle;
​            }
​            rain.push(i);
​            i++;
​        }
​        return sum;
​    }
};