package com.zerox.scala.from1001to1200

/**
 * @author ZeromaXHe
 * @since 2022/7/24 0:33
 * @note
 * 1184. 公交站间的距离 | 难度：简单 | 标签：数组
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 * 示例 1：
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *
 * 示例 2：
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 *
 * 示例 3：
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *
 * 提示：
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1184 {
  /**
   * 执行用时：480 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：53.7 MB, 在所有 Scala 提交中击败了 33.33% 的用户
   * 通过测试用例：37 / 37
   *
   * @param distance
   * @param start
   * @param destination
   * @return
   */
  def distanceBetweenBusStops(distance: Array[Int], start: Int, destination: Int): Int = {
    if (start > destination) distanceBetweenBusStops(distance, destination, start)
    else if (start == destination) 0
    else {
      var sum1 = 0
      var sum2 = 0
      for (i <- distance.indices) {
        if (i >= start && i < destination) sum1 += distance(i)
        else sum2 += distance(i)
      }
      math.min(sum1, sum2)
    }
  }
}
