package com.zerox.scala.from201to400

/**
 * @author zhuxi
 * @since 2022/10/29 16:24
 * @note
 * 243. 最短单词距离 | 难度：简单 | 标签：数组、字符串
 * 给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
 *
 * 示例 1:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * 输出: 3
 *
 * 示例 2:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出: 1
 *
 * 提示:
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] 由小写英文字母组成
 * word1 和 word2 在 wordsDict 中
 * word1 != word2
 */
object Solution243 {
  /**
   * 时间 492 ms 击败 100%
   * 内存 53.8 MB 击败 100%
   *
   * @param wordsDict
   * @param word1
   * @param word2
   * @return
   */
  def shortestDistance(wordsDict: Array[String], word1: String, word2: String): Int = {
    var last1 = -1
    var last2 = -1
    var shortest = Int.MaxValue
    for (i <- wordsDict.indices) {
      if (wordsDict(i) == word1) {
        if (last2 != -1) shortest = shortest min (i - last2)
        last1 = i
      } else if (wordsDict(i) == word2) {
        if (last1 != -1) shortest = shortest min (i - last1)
        last2 = i
      }
    }
    shortest
  }
}
