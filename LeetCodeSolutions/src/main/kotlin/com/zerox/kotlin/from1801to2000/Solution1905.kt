package com.zerox.kotlin.from1801to2000

/**
 * 1905. 统计子岛屿 | 难度：中等 | 标签：深度优先搜索、广度优先搜索、并查集、数组、矩阵
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 *
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 *
 * 请你返回 grid2 中 子岛屿 的 数目 。
 *
 * 示例 1：
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 *
 * 示例 2：
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * 输出：2
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
 *
 * 提示：
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-sub-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuxi
 * @since 2022/8/11 10:02
 */
object Solution1905 {
    /**
     * 执行用时：856 ms, 在所有 Kotlin 提交中击败了 100.00% 的用户
     * 内存消耗：77.1 MB, 在所有 Kotlin 提交中击败了 100.00% 的用户
     * 通过测试用例：57 / 57
     */
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var to = 2
        for (i in grid1.indices) {
            for (j in grid1[0].indices) {
                if (grid1[i][j] == 1) {
                    dfs(grid1, i, j, to)
                    to++
                }
            }
        }
        var result = 0
        for (i in grid2.indices) {
            for (j in grid2[0].indices) {
                if (grid2[i][j] == 1 && grid1[i][j] != 0 && dfsCheck(grid1, grid2, i, j, grid1[i][j])) result++
            }
        }
        return result
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int, to: Int) {
        grid[i][j] = to
        if (i - 1 >= 0 && grid[i - 1][j] == 1) dfs(grid, i - 1, j, to)
        if (j - 1 >= 0 && grid[i][j - 1] == 1) dfs(grid, i, j - 1, to)
        if (i + 1 < grid.size && grid[i + 1][j] == 1) dfs(grid, i + 1, j, to)
        if (j + 1 < grid[0].size && grid[i][j + 1] == 1) dfs(grid, i, j + 1, to)
    }

    private fun dfsCheck(grid1: Array<IntArray>, grid2: Array<IntArray>, i: Int, j: Int, to: Int): Boolean {
        grid2[i][j] = 0
        var result = true
        if (grid1[i][j] != to) result = false
        if (i - 1 >= 0 && grid2[i - 1][j] == 1 && !dfsCheck(grid1, grid2, i - 1, j, to)) result = false
        if (j - 1 >= 0 && grid2[i][j - 1] == 1 && !dfsCheck(grid1, grid2, i, j - 1, to)) result = false
        if (i + 1 < grid1.size && grid2[i + 1][j] == 1 && !dfsCheck(grid1, grid2, i + 1, j, to)) result = false
        if (j + 1 < grid1[0].size && grid2[i][j + 1] == 1 && !dfsCheck(grid1, grid2, i, j + 1, to)) result = false
        return result
    }
}