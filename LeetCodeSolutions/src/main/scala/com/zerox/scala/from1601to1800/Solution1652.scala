package com.zerox.scala.from1601to1800

/**
 * @author ZeromaXHe
 * @since 2022/9/24 13:39
 * @note
 * 1652. 拆炸弹 | 难度：简单 | 标签：数组
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 * 示例 1：
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * 示例 2：
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 *
 * 示例 3：
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 *
 * 提示：
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/defuse-the-bomb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution1652 {
  /**
   * 执行用时：460 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：52.7 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：74 / 74
   *
   * @param code
   * @param k
   * @return
   */
  def decrypt(code: Array[Int], k: Int): Array[Int] = {
    if (k == 0) new Array[Int](code.length)
    else {
      val preSum = new Array[Int](code.length + 1)
      for (i <- code.indices) {
        preSum(i + 1) = preSum(i) + code(i)
      }
      if (k > 0) {
        for (i <- code.indices) {
          code(i) = preSum(0 max (i + k + 1 - code.length)) +
            preSum(code.length min (i + k + 1)) - preSum(i + 1)
        }
      } else {
        for (i <- code.indices) {
          code(i) = preSum(code.length) - preSum(code.length min (code.length + k + i)) +
            preSum(i) - preSum(0 max (i + k))
        }
      }
      code
    }
  }
}
