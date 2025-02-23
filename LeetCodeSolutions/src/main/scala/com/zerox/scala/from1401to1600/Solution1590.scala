package com.zerox.scala.from1401to1600

/**
 * @author zhuxi
 * @since 2022/9/2 18:43
 * @note
 * 1590. 使数组和能被 P 整除 | 难度：中等 | 标签：数组、哈希表、前缀和
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 * 示例 1：
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 *
 * 示例 2：
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 *
 * 示例 3：
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 *
 * 示例  4：
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 *
 * 示例 5：
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1590 {
  /**
   * 执行用时：7360 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：85.6 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：142 / 142
   *
   * @param nums
   * @param p
   * @return
   */
  def minSubarray(nums: Array[Int], p: Int): Int = {
    var sum = 0
    val preSum = new Array[Int](nums.length + 1)
    for (i <- nums.indices) {
      sum = (sum + nums(i)) % p
      preSum(i + 1) = sum
    }
    if (sum == 0) return 0
    for (i <- 1 until nums.length; j <- i to nums.length if (preSum(j) - preSum(j - i) + p) % p == sum) {
      return i
    }
    -1
  }

  /**
   * 执行用时：828 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：81.8 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：142 / 142
   *
   * @param nums
   * @param p
   * @return
   */
  def minSubarray_hashMap(nums: Array[Int], p: Int): Int = {
    var sum = 0
    val preSum = new Array[Int](nums.length + 1)
    for (i <- nums.indices) {
      sum = (sum + nums(i)) % p
      preSum(i + 1) = sum
    }
    if (sum == 0) return 0
    var res = nums.length
    import scala.collection.mutable
    val map = new mutable.HashMap[Int, Int]
    map(0) = 0
    for (i <- nums.indices) {
      val target = (preSum(i + 1) - sum + p) % p
      if (map.contains(target)) {
        res = res min (i + 1 - map(target))
        if (res == 1) return res
      }
      map(preSum(i + 1)) = i + 1
    }
    if (res == nums.length) -1 else res
  }
}
