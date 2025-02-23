package com.zerox.scala.from1401to1600

/**
 * @author zhuxi
 * @since 2022/8/4 13:44
 * @note
 * 1402. 做菜顺序 | 难度：困难 | 标签：贪心、数组、动态规划、排序
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 *
 * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
 *
 * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 *
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 *
 * 示例 1：
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的喜爱时间系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 *
 * 示例 2：
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：按照原来顺序相反的时间做菜 (2*1 + 3*2 + 4*3 = 20)
 *
 * 示例 3：
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜可以获得最大的喜爱时间系数。
 *
 * 提示：
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reducing-dishes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1402 {
  /**
   * 执行用时：520 ms, 在所有 Scala 提交中击败了 50.00% 的用户
   * 内存消耗：53.3 MB, 在所有 Scala 提交中击败了 50.00% 的用户
   * 通过测试用例：60 / 60
   *
   * @param satisfaction
   * @return
   */
  def maxSatisfaction(satisfaction: Array[Int]): Int = {
    val sorted = satisfaction.sorted
    var idx = sorted.length
    var sum = 0
    while (idx > 0 && -sorted(idx - 1) < sum) {
      idx -= 1
      sum += sorted(idx)
    }
    var result = 0
    var multi = 1
    while (idx < sorted.length) {
      result += sorted(idx) * multi
      multi += 1
      idx += 1
    }
    result
  }
}
