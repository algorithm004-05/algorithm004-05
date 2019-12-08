//
//  88-mergeSortedArray.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa
/*
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]

 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
class MergeSortedArray: NSObject {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
    
        var writeIndex: Int = (n + m) - 1
        
        var m = m - 1
        var n = n - 1
        
        while m >= 0 && n >= 0 {
            if (nums1[m] < nums2[n]) {
                nums1[writeIndex] = nums2[n]
                n -= 1
                writeIndex -= 1
            } else {
                nums1[writeIndex] = nums1[m]
                m -= 1
                writeIndex -= 1
            }
        }
        
        while n >= 0 {
            nums1[writeIndex] = nums2[n]
            n -= 1
            writeIndex -= 1
        }
    }
}
