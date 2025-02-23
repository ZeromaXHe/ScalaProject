package com.zerox.kotlin.from1to200

/**
 * 53. 最大子数组和 | 难度：中等 | 标签：数组、分治、动态规划
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ZeromaXHe
 * @since 2022/8/13 13:32
 */
object Solution53 {
    @JvmStatic
    fun main(args: Array<String>) {
        maxSubArray(intArrayOf(1, 2, 3))
    }

    /**
     * 执行用时：476 ms, 在所有 Kotlin 提交中击败了 52.38% 的用户
     * 内存消耗：57.8 MB, 在所有 Kotlin 提交中击败了 49.20% 的用户
     * 通过测试用例：209 / 209
     */
    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var max = nums[0]
        for (num in nums) {
            sum += num
            if (sum < 0) sum = 0
            else if (sum > 0 && sum > max) {
                max = sum
            }
            if (num > max) max = num
        }
        return max
    }
}