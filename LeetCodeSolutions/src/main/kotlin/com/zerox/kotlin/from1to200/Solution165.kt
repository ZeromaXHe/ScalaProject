package com.zerox.kotlin.from1to200

/**
 * 165. 比较版本号 | 难度：中等 | 标签：双指针、字符串
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 返回规则如下：
 *
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 *
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 *
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 *
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 *
 * 提示：
 * 1 <= version1.length, version2.length <= 500
 * version1 和 version2 仅包含数字和 '.'
 * version1 和 version2 都是 有效版本号
 * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhuxi
 * @since 2022/8/16 15:20
 */
object Solution165 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(compareVersion("0", "1")) // -1
        println(compareVersion("1.1", "1.10")) // -1
    }

    /**
     * 执行用时：168 ms, 在所有 Kotlin 提交中击败了 52.94% 的用户
     * 内存消耗：32.7 MB, 在所有 Kotlin 提交中击败了 97.06% 的用户
     * 通过测试用例：82 / 82
     */
    fun compareVersion(version1: String, version2: String): Int {
        var p1 = 0
        var p2 = 0
        while (p1 < version1.length && p2 < version2.length) {
            var sum1 = 0
            var sum2 = 0
            while (p1 < version1.length && version1[p1] != '.') {
                sum1 *= 10
                sum1 += version1[p1] - '0'
                p1++
            }
            while (p2 < version2.length && version2[p2] != '.') {
                sum2 *= 10
                sum2 += version2[p2] - '0'
                p2++
            }
            if (sum1 > sum2) return 1
            if (sum1 < sum2) return -1
            p1++
            p2++
        }
        while (p1 < version1.length) {
            if (version1[p1] != '.' && version1[p1] != '0') return 1
            p1++
        }
        while (p2 < version2.length) {
            if (version2[p2] != '.' && version2[p2] != '0') return -1
            p2++
        }
        return 0
    }
}