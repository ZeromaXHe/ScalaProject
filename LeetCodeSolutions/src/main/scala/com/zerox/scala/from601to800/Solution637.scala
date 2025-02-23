package com.zerox.scala.from601to800

/**
 * @author zhuxi
 * @since 2022/8/5 17:48
 * @note
 * 637. 二叉树的层平均值 | 难度：简单 | 标签：树、深度优先搜索、广度优先搜索、二叉树
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 *
 * 示例 2:
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 *
 * 提示：
 * 树中节点数量在 [1, 104] 范围内
 * -231 <= Node.val <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution637 {
  /**
   * Definition for a binary tree node.
   * | class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
   * |   var value: Int = _value
   * |   var left: TreeNode = _left
   * |   var right: TreeNode = _right
   * | }
   *
   * 执行用时：688 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：56.6 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：66 / 66
   *
   * @param root
   * @return
   */
  def averageOfLevels(root: TreeNode): Array[Double] = {
    val queue = new scala.collection.mutable.Queue[TreeNode]
    queue += root
    val result = new scala.collection.mutable.ListBuffer[Double]
    while (queue.nonEmpty) {
      var size = queue.size
      var sum = 0.0
      val total = size
      while (size > 0) {
        val node = queue.dequeue()
        sum += node.value
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
        size -= 1
      }
      result += sum / total
    }
    result.toArray
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
}
