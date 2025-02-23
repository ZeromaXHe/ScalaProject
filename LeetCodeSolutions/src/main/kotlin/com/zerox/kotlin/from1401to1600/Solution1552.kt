package com.zerox.kotlin.from1401to1600

/**
 * 1552. 两球之间的磁力 | 难度：中等 | 标签：
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 *
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 *
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 *
 * 示例 1：
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 *
 * 示例 2：
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 *
 * 提示：
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/magnetic-force-between-two-balls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuxi
 * @since 2022/8/12 11:59
 */
object Solution1552 {
    /**
     * 执行用时：628 ms, 在所有 Kotlin 提交中击败了 100.00% 的用户
     * 内存消耗：55.5 MB, 在所有 Kotlin 提交中击败了 100.00% 的用户
     * 通过测试用例：98 / 98
     */
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()
        var l = 1
        var r = position[position.size - 1] - position[0]
        var result = 1
        while (l <= r) {
            val mid = (l + r) / 2
            var pre = position[0]
            var count = 1
            var i = 1
            while (i < position.size) {
                if (position[i] - pre >= mid) {
                    pre = position[i]
                    count++
                }
                i++
            }
            if (count >= m) {
                result = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return result
    }
}