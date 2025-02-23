package com.zerox.scala.from1201to1400

/**
 * @author zhuxi
 * @since 2022/7/12 9:55
 * @note
 * 1252. 奇数值单元格的数目 | 难度：简单 | 标签：数组、数学、模拟
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 * 示例 1：
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * 示例 2：
 * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *
 * 提示：
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 *
 * 进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1252 {
  /**
   * 执行用时：524 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：56.8 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：44 / 44
   *
   * @param m
   * @param n
   * @param indices
   * @return
   */
  def oddCells(m: Int, n: Int, indices: Array[Array[Int]]): Int = {
    val oddRow = indices.groupBy(_ (0)).filter(_._2.length % 2 == 1).keySet.size
    val oddCol = indices.groupBy(_ (1)).filter(_._2.length % 2 == 1).keySet.size
    m * oddCol + oddRow * n - 2 * oddCol * oddRow
  }

  /**
   * 执行用时：540 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：54.6 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：44 / 44
   *
   * @param m
   * @param n
   * @param indices
   * @return
   */
  def oddCells_count(m: Int, n: Int, indices: Array[Array[Int]]): Int = {
    val oddRow = indices.groupBy(_ (0)).count(_._2.length % 2 == 1)
    val oddCol = indices.groupBy(_ (1)).count(_._2.length % 2 == 1)
    m * oddCol + oddRow * n - 2 * oddCol * oddRow
  }
}
