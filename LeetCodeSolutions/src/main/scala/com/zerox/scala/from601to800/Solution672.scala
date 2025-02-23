package com.zerox.scala.from601to800

/**
 * @author zhuxi
 * @since 2022/9/15 10:08
 * @note
 * 672. 灯泡开关 Ⅱ | 难度：中等 | 标签：位运算、深度优先搜索、广度优先搜索、数学
 * 房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 *
 * 这 4 个开关各自都具有不同的功能，其中：
 *
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 *
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 *
 * 示例 1：
 * 输入：n = 1, presses = 1
 * 输出：2
 * 解释：状态可以是：
 * - 按压开关 1 ，[关]
 * - 按压开关 2 ，[开]
 *
 * 示例 2：
 * 输入：n = 2, presses = 1
 * 输出：3
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关]
 * - 按压开关 2 ，[开, 关]
 * - 按压开关 3 ，[关, 开]
 *
 * 示例 3：
 * 输入：n = 3, presses = 1
 * 输出：4
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关, 关]
 * - 按压开关 2 ，[关, 开, 关]
 * - 按压开关 3 ，[开, 关, 开]
 * - 按压开关 4 ，[关, 开, 开]
 *
 * 提示：
 * 1 <= n <= 1000
 * 0 <= presses <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bulb-switcher-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution672 {
  /**
   * 执行用时：452 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：51.4 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：80 / 80
   *
   * @param n
   * @param presses
   * @return
   */
  def flipLights(n: Int, presses: Int): Int = {
    val set = new scala.collection.mutable.HashSet[Int]
    for (i <- 0 until 16) {
      val pressArr = Array.tabulate(4)(j => (i >> j) & 1)
      val sum = pressArr.sum
      if (sum % 2 == presses % 2 && sum <= presses) {
        var status = pressArr(0) ^ pressArr(1) ^ pressArr(3)
        if (n >= 2) status |= (pressArr(0) ^ pressArr(1)) << 1
        if (n >= 3) status |= (pressArr(0) ^ pressArr(2)) << 2
        if (n >= 4) status |= (pressArr(0) ^ pressArr(1) ^ pressArr(3)) << 3
        set.add(status)
      }
    }
    set.size
  }
}
