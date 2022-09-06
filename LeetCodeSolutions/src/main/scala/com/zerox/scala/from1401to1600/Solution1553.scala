package com.zerox.scala.from1401to1600

/**
 * @author zhuxi
 * @since 2022/9/6 13:57
 * @note
 * 1553. 吃掉 N 个橘子的最少天数 | 难度：困难 | 标签：记忆化搜索、动态规划
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 *
 * 吃掉一个橘子。
 * 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 * 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 *
 * 请你返回吃掉所有 n 个橘子的最少天数。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：你总共有 10 个橘子。
 * 第 1 天：吃 1 个橘子，剩余橘子数 10 - 1 = 9。
 * 第 2 天：吃 6 个橘子，剩余橘子数 9 - 2*(9/3) = 9 - 6 = 3。（9 可以被 3 整除）
 * 第 3 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。
 * 第 4 天：吃掉最后 1 个橘子，剩余橘子数 1 - 1 = 0。
 * 你需要至少 4 天吃掉 10 个橘子。
 *
 * 示例 2：
 * 输入：n = 6
 * 输出：3
 * 解释：你总共有 6 个橘子。
 * 第 1 天：吃 3 个橘子，剩余橘子数 6 - 6/2 = 6 - 3 = 3。（6 可以被 2 整除）
 * 第 2 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。（3 可以被 3 整除）
 * 第 3 天：吃掉剩余 1 个橘子，剩余橘子数 1 - 1 = 0。
 * 你至少需要 3 天吃掉 6 个橘子。
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 *
 * 示例 4：
 * 输入：n = 56
 * 输出：6
 *
 * 提示：
 * 1 <= n <= 2*10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1553 {
  private val cache = new scala.collection.mutable.HashMap[Int, Int]
  cache(0) = 0
  cache(1) = 1

  /**
   * 执行用时：456 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：52.6 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：176 / 176
   *
   * 参考题解做的。直接动规或者记忆化的话会超空间，只有通过下面代码的方式，把记忆化的值限制为 2 和 3 的倍数，才能正常提交通过
   *
   * @param n
   * @return
   */
  def minDays(n: Int): Int = {
    cache.getOrElseUpdate(n, (n % 2 + 1 + minDays(n / 2)) min (n % 3 + 1 + minDays(n / 3)))
  }
}
