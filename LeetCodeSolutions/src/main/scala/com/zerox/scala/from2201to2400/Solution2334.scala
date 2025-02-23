package com.zerox.scala.from2201to2400

/**
 * @author zhuxi
 * @since 2022/7/29 11:35
 * @note
 * 2334. 元素值大于变化阈值的子数组 | 难度：困难 | 标签：栈、并查集、数组、单调栈
 * 给你一个整数数组 nums 和一个整数 threshold 。
 *
 * 找到长度为 k 的 nums 子数组，满足数组中 每个 元素都 大于 threshold / k 。
 *
 * 请你返回满足要求的 任意 子数组的 大小 。如果没有这样的子数组，返回 -1 。
 *
 * 子数组 是数组中一段连续非空的元素序列。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,3,1], threshold = 6
 * 输出：3
 * 解释：子数组 [3,4,3] 大小为 3 ，每个元素都大于 6 / 3 = 2 。
 * 注意这是唯一合法的子数组。
 *
 * 示例 2：
 * 输入：nums = [6,5,6,5,8], threshold = 7
 * 输出：1
 * 解释：子数组 [8] 大小为 1 ，且 8 > 7 / 1 = 7 。所以返回 1 。
 * 注意子数组 [6,5] 大小为 2 ，每个元素都大于 7 / 2 = 3.5 。
 * 类似的，子数组 [6,5,6] ，[6,5,6,5] ，[6,5,6,5,8] 都是符合条件的子数组。
 * 所以返回 2, 3, 4 和 5 都可以。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i], threshold <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subarray-with-elements-greater-than-varying-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution2334 {
  /**
   * 执行用时：1004 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：74 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：68 / 68
   *
   * @param nums
   * @param threshold
   * @return
   */
  def validSubarraySize(nums: Array[Int], threshold: Int): Int = {
    val n = nums.length
    val left = new Array[Int](n)
    val stack = new scala.collection.mutable.Stack[Int]
    for (i <- 0 until n) {
      while (stack.nonEmpty && nums(stack.top) >= nums(i)) stack.pop()
      left(i) = if (stack.isEmpty) -1 else stack.top
      stack.push(i)
    }
    val right = new Array[Int](n)
    stack.clear()
    for (i <- Range(n - 1, -1, -1)) {
      while (stack.nonEmpty && nums(stack.top) >= nums(i)) stack.pop()
      right(i) = if (stack.isEmpty) n else stack.top
      stack.push(i)
    }
    for (i <- 0 until n) {
      val k = right(i) - left(i) - 1
      if (nums(i) > threshold / k) return k
    }
    -1
  }
}
