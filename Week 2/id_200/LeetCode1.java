//哈希法

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>  map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if(map.containsKey(x) && map.get(x) != i){
                return new int[]{i,map.get(x)};
            }
        }
        return new int[-1,-1];
    }
}

//双指针法

class Solution {
    int[] twoSum(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            return new int[]{left, right};
        } else if (sum < target) {
            left++; // 让 sum 大一点
        } else if (sum > target) {
            right--; // 让 sum 小一点
        }
    }
    // 不存在这样两个数
    return new int[]{-1, -1};
 }
}