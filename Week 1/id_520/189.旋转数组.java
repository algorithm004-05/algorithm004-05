/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {

        // // 双重循环法，
        // // 时间复杂度：O(kn)
        // // 空间复杂度：O(1)
        // // 按照轮次数来做，每一轮，操作每一个不同的元素
        // int nums_length  = nums.length;
        // // 如果k太大，甚至比nums还大，那么移动过程会经过一轮，在这里k表示最后要位移的位数。
        // k %= nums_length;
        // for (int i = 0; i < k; i++){
        //     // temp保留最后一个元素的值
        //     int temp = nums[nums_length - 1];
        //     // 每次操作把坐标小的元素移动到坐标大1的位置
        //     for (int j = nums_length-1; j > 0; j--) {
        //         nums[j] = nums[j - 1];
        //     }
        //     nums[0] = temp;
        // }

    //     // 循环交换
    //     // 时间复杂度：O(n)
    //     // 空间复杂度：O(1)
    //     int nums_length = nums.length;
    //     k %= nums_length;
    //     // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
    //     for (int i = 0; i < nums.length && k != 0; nums_length -= k, i += k, k %= nums_length) {
    //         for (int j = 0; j < k; j++) {
    //             swap(nums, i + j, nums.length - k + j);
    //         }
    //     }
    // }

    //         private void swap(int [] nums, int i, int j){
    //         int temp = nums[i];
    //         nums[i] = nums[j];
    //         nums[j] = temp;
    //     }

    //方法三 翻转， 最巧妙
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)

    int nums_length = nums.length;
    // 如果k太大，甚至比nums还大，那么移动过程会经过一轮，在这里k表示最后要位移的位数。
    k %= nums_length;
    reverse(nums, 0, nums_length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums_length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

// *arr = [1,2,3,4,5] --右移两位--> [4,5,1,2,3] 
// 假设 n = arr.length，k = 右移位数，可得：  
//      [1,2,3,4,5] --翻转索引为[0,n-1]之间的元素--> [5,4,3,2,1] 
//                  --翻转索引为[0,k-1]之间的元素--> [4,5,3,2,1] 
//                  --翻转索引为[k,n-1]之间的元素--> [4,5,1,2,3]
                 
// 旋转数组其实就是把数组分成了两部分，解题关键就是在保证原有顺序的情况下
// 把后面一部分移到前面去。数组整体翻转满足了第二个要素，但是打乱了数组的
// 原有顺序，所以此时再次对两部分进行翻转，让他们恢复到原有顺序（翻转之后
// 再翻转，就恢复成原有顺序了）。没有什么太复杂的思想，我也不清楚算法作者
// 的灵感来自哪。不过我看到这个算法的时候脑袋里想的是“汉诺塔”，也许有渊源
// 也说不定~


}
// @lc code=end

