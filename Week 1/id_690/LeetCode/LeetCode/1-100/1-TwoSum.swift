//
//  1-TwoSum.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa

/*:
给定一个整数数组nums和一个目标值 target,请你在该数组中找出和为目标值的那两个整数,并返回他们的数组下标

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

[1.两数之和](https://leetcode-cn.com/problems/two-sum)


*/

class TwoSum: NSObject {

    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        
        var dict: [Int: Int] = [:]
        
        for (index, value) in nums.enumerated() {
            
            if let t = dict[target - value] {
                return [t, index]
            } else {
                dict[value] = index
            }
        }
        
        return []
    }
}
