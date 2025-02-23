package com.zerox.scala.from2201to2400

/**
 * @author zhuxi
 * @since 2022/7/29 16:47
 * @note
 * 2262. 字符串的总引力 | 难度：困难 | 标签：哈希表、字符串、动态规划
 * 字符串的 引力 定义为：字符串中 不同 字符的数量。
 *
 * 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
 * 给你一个字符串 s ，返回 其所有子字符串的总引力 。
 *
 * 子字符串 定义为：字符串中的一个连续字符序列。
 *
 * 示例 1：
 * 输入：s = "abbca"
 * 输出：28
 * 解释："abbca" 的子字符串有：
 * - 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
 * - 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
 * - 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
 * - 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
 * 引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
 *
 * 示例 2：
 * 输入：s = "code"
 * 输出：20
 * 解释："code" 的子字符串有：
 * - 长度为 1 的子字符串："c"、"o"、"d"、"e" 的引力分别为 1、1、1、1 ，总和为 4 。
 * - 长度为 2 的子字符串："co"、"od"、"de" 的引力分别为 2、2、2 ，总和为 6 。
 * - 长度为 3 的子字符串："cod"、"ode" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 4 的子字符串："code" 的引力为 4 ，总和为 4 。
 * 引力总和为 4 + 6 + 6 + 4 = 20 。
 *
 * 提示：
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/total-appeal-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution2262 {
  /**
   * 执行用时：540 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：53.2 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：76 / 76
   *
   * @param s
   * @return
   */
  def appealSum(s: String): Long = {
    val last = Array.fill(26)(-1)
    var sum = 0L
    var g = 0
    for (i <- 0 until s.length) {
      g += i - last(s(i) - 'a')
      sum += g
      last(s(i) - 'a') = i
    }
    sum
  }

  /**
   * 超时
   *
   * @param s
   * @return
   */
  def appealSum_timeout(s: String): Long = {
    val count = new Array[Int](26)
    val charCounts = Array.tabulate[Array[Int]](s.length + 1) {
      case 0 => count.clone()
      case i =>
        count(s(i - 1) - 'a') += 1
        count.clone()
    }
    var sum = 0L
    for (i <- 0 until s.length; j <- i + 1 to s.length) {
      sum += gravity(charCounts(i), charCounts(j))
    }
    sum
  }

  private def gravity(count1: Array[Int], count2: Array[Int]): Int = {
    var g = 0
    for (i <- 0 until 26 if count2(i) - count1(i) > 0) {
      g += 1
    }
    g
  }
}
