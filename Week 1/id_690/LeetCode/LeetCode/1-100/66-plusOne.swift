//
//  66-plusOne.swift
//  LeetCode
//
//  Created by 张银龙 on 2019/10/20.
//  Copyright © 2019 张银龙. All rights reserved.
//

import Cocoa
/*
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。

 链接：https://leetcode-cn.com/problems/plus-one
 */
class PlusOne: NSObject {
    
    func plusOne(_ digits: [Int]) -> [Int] {
        
        var digits = digits
        
        for index in stride(from: digits.count-1, to: -1, by: -1) {
            
            let plusOne = digits[index] + 1
            
            if plusOne % 10 != 0 {
                //  没有进位, 返回结果
                digits[index] = plusOne
                break
            } else {
                // 有进位
                digits[index] = 0
            }
        }
        
        // 第一位是 0, 加一位
        if  digits[0] == 0 {
            var newDigits = Array(repeating: 0, count: digits.count + 1)
            newDigits[0] = 1
            return newDigits
        }
        
        return digits
    }
}
