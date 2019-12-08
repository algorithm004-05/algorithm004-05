/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
    let p1 = 0,p2 = 0, p = 0, nums1_copy = []
    Object.assign(nums1_copy,nums1)
    for(p;p< nums1.length;++p){
        if((p1 === m)|| (p2 === n)){
            if(p1 === m){
                nums1[p] = nums2[p2++]
            }else{
                nums1[p] = nums1_copy[p1++]
            }
        }else if (nums1_copy[p1] < nums2[p2]){
            nums1[p] = nums1_copy[p1++]
        }else{
            nums1[p] = nums2[p2++]
        }
    }
};
