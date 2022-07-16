package com.zerox.from401to600

/**
 * @author ZeromaXHe
 * @since 2022/7/17 1:17
 * @note
 * 565. 数组嵌套 | 难度：中等 | 标签：深度优先搜索、数组
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 * 示例 1:
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * 提示：
 * N是[1, 20,000]之间的整数。
 * A中不含有重复的元素。
 * A中的元素大小在[0, N-1]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution565 {
  /**
   * 执行用时：884 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：80.2 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：885 / 885
   *
   * @param nums
   * @return
   */
  def arrayNesting(nums: Array[Int]): Int = {
    var max = 0
    for (i <- nums.indices if nums(i) != -1) {
      var len = 0
      var pre = i
      var index = i
      while (nums(index) != -1) {
        pre = index
        index = nums(index)
        nums(pre) = -1
        len += 1
      }
      if (len > max) max = len
    }
    max
  }
}
