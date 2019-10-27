class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // 空间换时间
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {

            int tmp = target-nums[i];
            
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            } 
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        
//         int[] res = new int[2];
        
//         for (int i=0; i<nums.length-1; i++) {
            
//             for (int j=i+1; j<nums.length; j++) {
                
//                 if (target == (nums[i] + nums[j])) {
//                     res[0] = i;
//                     res[1] = j;
//                 }
//             }
//         }
        
//         return res;
//     }
// }
