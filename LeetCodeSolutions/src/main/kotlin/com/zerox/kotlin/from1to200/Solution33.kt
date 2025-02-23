package com.zerox.kotlin.from1to200

import java.util.*

/**
 * 33. 搜索旋转排序数组 | 难度：中等 | 标签：数组、二分查找
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuxi
 * @since 2022/8/9 10:37
 */
object Solution33 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(search(intArrayOf(4,5,6,7,0,1,2), 0))
    }
    /**
     * 执行用时：168 ms, 在所有 Kotlin 提交中击败了 81.48% 的用户
     * 内存消耗：34.3 MB, 在所有 Kotlin 提交中击败了 91.67% 的用户
     * 通过测试用例：195 / 195
     */
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            if (nums[l] == target) return l
            if (nums[r] == target) return r
            val mid = (l + r) / 2
            if (nums[mid] == target) return mid
            if (nums[l] < nums[mid]) {
                // l 到 mid 是递增的
                if (nums[mid] > target && target > nums[l]) r = mid - 1
                else l = mid + 1
            } else {
                // mid 到 right 是递增的
                if (nums[mid] < target && target < nums[r]) l = mid + 1
                else r = mid - 1
            }
        }
        return -1
    }
}