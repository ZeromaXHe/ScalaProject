package com.zerox.kotlin.from1to200

/**
 * 122. 买卖股票的最佳时机 II | 难度：中等 | 标签：贪心、数组、动态规划
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 *
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 *
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 * 提示：
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuxi
 * @since 2022/8/15 18:58
 */
object Solution122 {
    /**
     * 执行用时：192 ms, 在所有 Kotlin 提交中击败了 56.94% 的用户
     * 内存消耗：34.6 MB, 在所有 Kotlin 提交中击败了 83.33% 的用户
     * 通过测试用例：200 / 200
     */
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var pre = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] > pre) result += prices[i] - pre
            pre = prices[i]
        }
        return result
    }
}