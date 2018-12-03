package stifred.aoc18.firstkt

import stifred.aoc18.December

class KotlinFirst : December {
  override fun firstChallenge(input: String): String {
    return input
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
        .fold(0) { sum, current -> sum + current }
        .toString()
  }

  override fun secondChallenge(input: String): String {
    var doubleVal: Int = -1
    val freqList = HashSet<Int>()
    val freqLogger = { i: Int ->
      if (!freqList.add(i) && doubleVal == -1) {
        doubleVal = i
      }
      i
    }

    val changes = input
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    var currentSum = 0
    while (doubleVal == -1) {
      for (change in changes) {
        currentSum += change
        freqLogger.invoke(currentSum)
      }
    }

    return doubleVal.toString()
  }

}
