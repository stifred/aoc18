package stifred.aoc18.firstkt

import org.junit.Assert.assertEquals
import org.junit.Test

class KotlinFirstTest {
  private val first = KotlinFirst()

  @Test
  fun testFirstChallenge() {
    val input1 = ""
    val input2 = "+5"
    val input3 = "+5\n-3\n+0\n+1\n"

    val output1 = first.firstChallenge(input1)
    val output2 = first.firstChallenge(input2)
    val output3 = first.firstChallenge(input3)

    assertEquals("0", output1)
    assertEquals("5", output2)
    assertEquals("3", output3)
  }
}