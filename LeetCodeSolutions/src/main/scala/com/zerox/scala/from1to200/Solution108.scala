package com.zerox.scala.from1to200

/**
 * @author zhuxi
 * @since 2022/8/23 11:38
 * @note
 * 108. 将有序数组转换为二叉搜索树 | 难度：简单 | 标签：树、二叉搜索树、数组、分治、二叉树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution108 {
  /**
   * 执行用时：660 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：55.3 MB, 在所有 Scala 提交中击败了 42.86% 的用户
   * 通过测试用例：31 / 31
   *
   * @param nums
   * @return
   */
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    sortedArrayToBST(nums, 0, nums.length)
  }

  def sortedArrayToBST(nums: Array[Int], from: Int, to: Int): TreeNode = {
    if (to <= from) return null
    val mid = from + (to - from) / 2
    new TreeNode(nums(mid), sortedArrayToBST(nums, from, mid), sortedArrayToBST(nums, mid + 1, to))
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
}
