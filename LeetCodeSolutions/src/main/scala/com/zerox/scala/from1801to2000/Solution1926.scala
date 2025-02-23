package com.zerox.scala.from1801to2000

/**
 * @author ZeromaXHe
 * @since 2022/8/14 14:11
 * @note
 * 1926. 迷宫中离入口最近的出口 | 难度：中等 | 标签：广度优先搜索、数组、矩阵
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 *
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 *
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 *
 * 示例 1：
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 *
 * 示例 2：
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 *
 * 示例 3：
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 *
 * 提示：
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] 要么是 '.' ，要么是 '+' 。
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance 一定是空格子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1926 {
  def main(args: Array[String]): Unit = {
    println(nearestExit(Array(
      Array('+', '.', '+', '+', '+', '+', '+'),
      Array('+', '.', '+', '.', '.', '.', '+'),
      Array('+', '.', '+', '.', '+', '.', '+'),
      Array('+', '.', '.', '.', '+', '.', '+'),
      Array('+', '+', '+', '+', '+', '.', '+')
    ), Array(0, 1)))
  }

  /**
   * 执行用时：716 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：57.3 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：194 / 194
   *
   * @param maze
   * @param entrance
   * @return
   */
  def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
    val queue = new scala.collection.mutable.Queue[(Int, Int)]
    queue.enqueue((entrance(0), entrance(1)))
    maze(entrance(0))(entrance(1)) = '*'
    var dist = 0
    while (queue.nonEmpty) {
      var size = queue.size
      while (size > 0) {
        val (x, y) = queue.dequeue()
        if (dist > 0 && (x == 0 || x == maze.length - 1 || y == 0 || y == maze(0).length - 1)) return dist
        if (x + 1 < maze.length && maze(x + 1)(y) == '.') {
          queue.enqueue((x + 1, y))
          maze(x + 1)(y) = '*'
        }
        if (x - 1 >= 0 && maze(x - 1)(y) == '.') {
          queue.enqueue((x - 1, y))
          maze(x - 1)(y) = '*'
        }
        if (y + 1 < maze(0).length && maze(x)(y + 1) == '.') {
          queue.enqueue((x, y + 1))
          maze(x)(y + 1) = '*'
        }
        if (y - 1 >= 0 && maze(x)(y - 1) == '.') {
          queue.enqueue((x, y - 1))
          maze(x)(y - 1) = '*'
        }
        size -= 1
      }
      dist += 1
    }
    -1
  }
}
