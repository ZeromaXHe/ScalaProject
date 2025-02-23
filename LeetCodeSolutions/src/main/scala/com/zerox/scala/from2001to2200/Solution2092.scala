package com.zerox.scala.from2001to2200

/**
 * @author zhuxi
 * @since 2022/8/26 17:43
 * @note
 * 2092. 找出知晓秘密的所有专家 | 难度：困难 | 标签：深度优先搜索、广度优先搜索、并查集、图、排序
 * 给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另外给你一个下标从 0 开始的二维整数数组 meetings ，其中 meetings[i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会。一个专家可以同时参加 多场会议 。最后，给你一个整数 firstPerson 。
 *
 * 专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传播。更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。
 *
 * 秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。
 *
 * 在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * 输出：[0,1,2,3,5]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 5 ，专家 1 将秘密与专家 2 共享。
 * 时间 8 ，专家 2 将秘密与专家 3 共享。
 * 时间 10 ，专家 1 将秘密与专家 5 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 5 都将知晓这个秘密。
 *
 * 示例 2：
 * 输入：n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * 输出：[0,1,3]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 3 共享。
 * 时间 2 ，专家 1 与专家 2 都不知晓这个秘密。
 * 时间 3 ，专家 3 将秘密与专家 0 和专家 1 共享。
 * 因此，在所有会议结束后，专家 0、1 和 3 都将知晓这个秘密。
 *
 * 示例 3：
 * 输入：n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * 输出：[0,1,2,3,4]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 1 ，专家 1 将秘密与专家 2 共享，专家 2 将秘密与专家 3 共享。
 * 注意，专家 2 可以在收到秘密的同一时间分享此秘密。
 * 时间 2 ，专家 3 将秘密与专家 4 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 4 都将知晓这个秘密。
 *
 * 提示：
 * 2 <= n <= 105
 * 1 <= meetings.length <= 105
 * meetings[i].length == 3
 * 0 <= xi, yi <= n - 1
 * xi != yi
 * 1 <= timei <= 105
 * 1 <= firstPerson <= n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-people-with-secret
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution2092 {
  /**
   * 执行用时：1704 ms, 在所有 Scala 提交中击败了 100.00% 的用户
   * 内存消耗：116.8 MB, 在所有 Scala 提交中击败了 100.00% 的用户
   * 通过测试用例：60 / 60
   *
   * @param n
   * @param meetings
   * @param firstPerson
   * @return
   */
  def findAllPeople(n: Int, meetings: Array[Array[Int]], firstPerson: Int): List[Int] = {
    val set = new UnionSet(n)
    set.union(0, firstPerson)
    val sortMeet = meetings.sortBy(_ (2))
    var t = sortMeet(0)(2)
    val met = new scala.collection.mutable.HashSet[Int]
    for (m <- sortMeet) {
      if (m(2) > t) {
        set.dismissUnknown(0, met)
        met.clear()
        t = m(2)
      }
      set.union(m(0), m(1))
      met.add(m(0))
      met.add(m(1))
    }
    set.getKnownList(0)
  }

  class UnionSet(n: Int) {
    private val parent = Array.tabulate(n)(identity)
    private val size = Array.fill(n)(1)

    def find(x: Int): Int = {
      if (x != parent(x)) parent(x) = find(parent(x))
      parent(x)
    }

    def union(x: Int, y: Int): Unit = {
      val rootX = find(x)
      val rootY = find(y)
      if (rootX == rootY) return
      val big = if (size(rootX) < size(rootY)) rootY else rootX
      val small = if (size(rootX) < size(rootY)) rootX else rootY
      parent(small) = big
      size(big) += size(small)
    }

    def getSize(x: Int): Int = {
      size(find(x))
    }

    def getKnownList(known: Int): List[Int] = {
      val root = find(known)
      (for (i <- parent.indices if find(i) == root) yield i).toList
    }

    def dismissUnknown(known: Int, met: scala.collection.mutable.HashSet[Int]): Unit = {
      val root = find(known)
      for (i <- met if find(i) != root) {
        parent(i) = i
      }
    }
  }
}
