
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 遍历nums2,追加到nums1中
        for(int i = 0; i<nums2.length; i++){
            nums1[m+i] = nums2[i];
        }
        //直接使用java数组排序工具类
        Arrays.sort(nums1);
    }
}
