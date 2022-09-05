package com.zerox.scala.aider

/**
 * @author zhuxi
 * @since 2022/9/5 14:29
 * @note
 * 动态规划工具类
 */
object DynamicProgrammingUtils {
  def dpOneDimension[T](n: Int, inits: List[(Int, T)], coords: List[Int => Int],
                        trans: (Array[T], List[Int => Int]) => T, from: Int): Array[T] = {
    val dp = new Array[T](n)
    for ((i, elem) <- inits) dp(i) = elem
    for(i <- from until n) dp(i) = trans(dp, coords)
    dp
  }
}
