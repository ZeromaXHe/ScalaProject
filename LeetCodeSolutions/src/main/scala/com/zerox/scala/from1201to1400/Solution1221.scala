package com.zerox.scala.from1201to1400

/**
 * @author zhuxi
 * @since 2022/9/21 11:26
 * @note
 * 1221. 分割平衡字符串 | 难度：简单 | 标签：贪心、字符串、计数
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 示例 2：
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 示例 3：
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *
 * 示例 4：
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1221 {
  /**
   * 执行用时：440 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：52.4 MB, 在所有 Scala 提交中击败了 50.00% 的用户
   * 通过测试用例：40 / 40
   *
   * @param s
   * @return
   */
  def balancedStringSplit(s: String): Int = {
    var count = 0
    var res = 0
    for (c <- s) {
      if (c == 'L') count -= 1
      else count += 1
      if (count == 0) res += 1
    }
    res
  }
}
