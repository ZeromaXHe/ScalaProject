package com.zerox

/**
 * @author ZeromaXHe
 * @since 2022/7/6 23:29
 * @note
 */
object Solution46 {
  def main(args: Array[String]): Unit = {
    println(Array(1, 2, 3).toList)
    println(permute(Array(1, 2, 3)))
    println(perm("ABC"))
    println(List(1,2,3) diff List(3))
  }

  def perm[A]: Seq[A] => Seq[Seq[A]] = {
    case Seq() => Seq(Nil);
    case xs => for (x <- xs; rs <- perm(xs diff Seq(x))) yield x +: rs
  }

  /**
   * 执行用时：552 ms, 在所有 Scala 提交中击败了 36.67% 的用户
   * 内存消耗：54.7 MB, 在所有 Scala 提交中击败了 46.67% 的用户
   * 通过测试用例：26 / 26
   *
   * @param nums
   * @return
   */
  def permute(nums: Array[Int]): List[List[Int]] = {
    def perm: List[Int] => List[List[Int]] = {
      case List() => List(Nil);
      case xs => for (x <- xs; rs <- perm(xs diff List(x))) yield x +: rs
    }

    perm(nums.toList)
  }
}
