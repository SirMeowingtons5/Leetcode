package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import utils.toReversedInt
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class AddTwoNumbersTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(listNodeOf(2, 4, 3), listNodeOf(5, 6, 4), 807),
                arguments(listNodeOf(0), listNodeOf(0), 0),
                arguments(listNodeOf(9, 9, 9, 9, 9, 9, 9), listNodeOf(9, 9, 9, 9), 10009998)
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `example 1`(l1: ListNode, l2: ListNode, expected: Int) {
        val actual = AddTwoNumbers().addTwoNumbers(l1, l2).toReversedInt()

        assertEquals(expected, actual)
    }
}