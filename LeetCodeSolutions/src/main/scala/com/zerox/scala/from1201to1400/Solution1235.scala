package com.zerox.scala.from1201to1400

/**
 * @author zhuxi
 * @since 2022/9/1 13:40
 * @note
 * 1235. 规划兼职工作 | 难度：困难 | 标签：数组、二分查找、动态规划、排序
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 *
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 *
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 *
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 *
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 *
 * 示例 1：
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 *
 * 示例 2：
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 *
 * 示例 3：
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 *
 * 提示：
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
 * 1 <= startTime[i] < endTime[i] <= 10^9
 * 1 <= profit[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-profit-in-job-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1235 {
  /**
   * 执行用时：940 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：65 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：30 / 30
   *
   * 贪心 + 堆 + 排序，参考题解做的
   * 主要思路就是按照时间顺序贪心，最后取最大值
   *
   * @param startTime
   * @param endTime
   * @param profit
   * @return
   */
  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    // 小顶堆
    val heap = new scala.collection.mutable.PriorityQueue[Array[Int]]()(Ordering.by[Array[Int], Int](_ (1)).reverse)
    val idx = startTime.indices.sortBy(startTime(_))
    var max = 0
    for (i <- startTime.indices) {
      while (heap.nonEmpty && heap.head(1) <= startTime(idx(i))) max = math.max(max, heap.dequeue()(0))
      heap.enqueue(Array(max + profit(idx(i)), endTime(idx(i))))
    }
    while (heap.nonEmpty) max = math.max(max, heap.dequeue()(0))
    max
  }

  /**
   * 执行用时：788 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：62.4 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：30 / 30
   *
   * 动规 + 二分查找，参考题解做的
   *
   * @param startTime
   * @param endTime
   * @param profit
   * @return
   */
  def jobScheduling_dp(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    val n = startTime.length
    // 按结束时间排序
    val jobs = (0 until n).map(i => Array(startTime(i), endTime(i), profit(i))).sortBy(_ (1)).toArray
    val dp = new Array[Int](n + 1)
    for (i <- 1 to n) {
      var l = 0
      var r = i
      while (l < r - 1) {
        val mid = l + (r - l) / 2
        if (jobs(mid - 1)(1) <= jobs(i - 1)(0)) l = mid else r = mid
      }
      dp(i) = math.max(dp(i - 1), dp(l) + jobs(i - 1)(2))
    }
    dp(n)
  }
}
